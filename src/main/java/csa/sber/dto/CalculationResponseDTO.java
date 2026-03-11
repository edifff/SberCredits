package csa.sber.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class CalculationResponseDTO {

    private Long dealId;

    private BigDecimal creditAmount;

    private BigDecimal balanceOnDate;

    private BigDecimal balanceInOneYear;

}
