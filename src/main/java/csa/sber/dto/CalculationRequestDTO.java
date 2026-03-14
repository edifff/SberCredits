package csa.sber.dto;

import csa.sber.entity.enums.Currency;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CalculationRequestDTO {

    @NotNull
    private Long dealNumber;

    @NotNull
    private LocalDate calculationDate;

    @NotNull
    private Currency targetCurrency;
}
