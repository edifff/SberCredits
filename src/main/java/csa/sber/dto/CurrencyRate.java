package csa.sber.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CurrencyRate {

    @JsonProperty("CharCode")
    private String CharCode;

    @JsonProperty("Valute")
    private BigDecimal Valute;
}
