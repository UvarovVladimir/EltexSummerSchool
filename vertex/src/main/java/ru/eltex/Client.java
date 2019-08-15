package ru.eltex;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpVersion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Client {
    public static void vkRequest() throws IOException, InterruptedException {
        FileInputStream fis;
        fis = new FileInputStream("src/main/resources/vk.properties");
        Properties pr = new Properties();
        pr.load(fis);
        String token = pr.getProperty("vk.token");
        while (true) {
            Thread.sleep(4000);
            System.out.println("Enter user id:");
            Scanner in = new Scanner(System.in);
            String id = in.nextLine();
            System.out.println("Enter user field, or press enter for standard request:");
            String field = in.nextLine();
            if (field.equals("")) field = "bdate";
            Vertx vertx = Vertx.vertx(); // количество обработчиков
            HttpClientOptions options = new HttpClientOptions()
                    .setProtocolVersion(HttpVersion.HTTP_2)
                    .setSsl(true)
                    .setUseAlpn(true)
                    .setTrustAll(true);
            HttpClient client = vertx.createHttpClient(options);
            String request = "https://api.vk.com/method/users.get?user_ids=" + id + "&fields=" + field +
                    "&access_token=" + token + "&v=5.101";
            client.requestAbs(HttpMethod.GET, request,
                    result -> {
                        System.out.println(result.statusCode());
                        result.bodyHandler(body -> {
                            System.out.println(body.toString());
                        });
                    }).end();

        }
    }
}
//        32999370
//        7739185
   /*     Доступные значения: photo_id, verified, sex, bdate, city, country, home_town, has_photo, photo_50,
    photo_100, photo_200_orig, photo_200, photo_400_orig, photo_max, photo_max_orig, online, domain, has_mobile,
    contacts, site, education, universities, schools, status, last_seen, followers_count, common_count, occupation,
    nickname, relatives, relation, personal, connections, exports, activities, interests, music, movies, tv, books,
    games, about, quotes, can_post, can_see_all_posts, can_see_audio, can_write_private_message,
     can_send_friend_request, is_favorite, is_hidden_from_feed, timezone, screen_name, maiden_name, crop_photo,
      is_friend, friend_status, career, military, blacklisted, blacklisted_by_me, can_be_invited_group.*/
//sdfsdfsdfsdfsdf