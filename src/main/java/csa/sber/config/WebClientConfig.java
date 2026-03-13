package csa.sber.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient cbrWebClient(){
        return WebClient.builder().baseUrl("https://www.cbr-xml-daily.ru").build();
    }
}
