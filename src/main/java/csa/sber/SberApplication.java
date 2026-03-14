package csa.sber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
public class SberApplication {
    //TO DO
//            1. Добавить DTO для каждого типа запроса.
//            2. Поменять везде с Long на String у dealNumber и PaymentNumber
//            3. Разобраться с количеством сервисом и разбиением классов
//            4. Перейти на RestTemplate
//            5. Добавить авторизацию
    public static void main(String[] args) {
        SpringApplication.run(SberApplication.class, args);
    }

}
