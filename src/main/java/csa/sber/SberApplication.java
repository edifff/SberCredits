package csa.sber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SberApplication {

    public static void main(String[] args) {
        SpringApplication.run(SberApplication.class, args);
    }

}
