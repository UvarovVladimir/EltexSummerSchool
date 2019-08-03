package ru.eltex;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.eltex.entity.Call;
import ru.eltex.entity.User;

import java.util.Calendar;
//
//public class SpringDb {
//    public static void springDo() {

@SpringBootApplication // автоконфигурирование, обозначение точки входа
public class SpringDb {
    public static void main(String[] args) {
        SpringApplication.run(SpringDb.class);
    }

    @Bean // компонент контекста Spring
    public CommandLineRunner demo(UserRepository crudRepository) {
        return (args) -> {
            Call call1 = new Call("IvanFG", "Boris FG",234);
            call1.getDate().set(Calendar.YEAR, 2017);

            call1.getDate().set(Calendar.MONTH, 1);
            Call call2 = new Call("DDDD", "Boris FGFF",333);
//            new Call("DDDD", "Boris FGFF",333)
            call2.getDate().set(Calendar.YEAR, 2018);

            call2.getDate().set(Calendar.MONTH, 2);
            crudRepository.save(call1);

            crudRepository.save(call2);
            for (Call call : crudRepository.findAll()) {
                System.out.println(call.toString());
            }
        };
    }
}

//
//    }
//
//
//}

