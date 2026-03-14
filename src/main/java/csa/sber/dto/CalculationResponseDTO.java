package csa.sber.dto;

import csa.sber.entity.enums.Currency;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class CalculationResponseDTO {

    private Long dealNumber;

    private BigDecimal creditAmount;
    private Currency creditAmountCurrency;

    private BigDecimal balanceOnDate;
    private Currency balanceOnDateCurrency;

    private BigDecimal balanceInOneYear;
    private Currency balanceInOneYearCurrency;

}