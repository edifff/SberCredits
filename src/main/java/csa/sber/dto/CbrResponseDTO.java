package csa.sber.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.Map;

@Getter
public class CbrResponseDTO {

    @JsonProperty("Date")
    private OffsetDateTime Date;

    @JsonProperty("Value")
    private Map<String, CurrencyRate> Valute;
}