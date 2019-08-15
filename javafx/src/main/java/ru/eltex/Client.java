package ru.eltex;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpVersion;
public class Client {
    public static void userRequest()  {
        System.out.println("Start request:");
        Vertx vertx = Vertx.vertx();
        HttpClientOptions options = new HttpClientOptions()
                .setProtocolVersion(HttpVersion.HTTP_2)
                .setSsl(true)
                .setUseAlpn(true)
                .setTrustAll(true);
        HttpClient client = vertx.createHttpClient(options);
        String request = "http://localhost:8088/get_users";

        client.requestAbs(HttpMethod.GET, request, (result) -> {
            System.out.println(result.statusCode());
            result.bodyHandler(body -> {
                System.out.println(body.toString());
                Storage.setLine(body.toString());
            });
        }).end();
    }
}

