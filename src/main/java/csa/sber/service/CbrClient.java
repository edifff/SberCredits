package csa.sber.service;

import csa.sber.dto.CbrResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@AllArgsConstructor
public class CbrClient {
    private final WebClient webClient;

    public CbrResponseDTO getRates(){
        return webClient.get().uri("/daily_json.js").retrieve().bodyToMono(CbrResponseDTO.class).block();
    }
}
