package csa.sber.dto.rate;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Date;

@Getter
@Builder
public class ExchangeRateInfoDTO {
    private BigDecimal rateUsd;
    private BigDecimal rateEur;
    private OffsetDateTime date;
}
