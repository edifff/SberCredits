package csa.sber.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class CreditRequestDTO {

    @NotNull
    @DecimalMin("0.01")
    private BigDecimal creditAmount;

    @NotNull
    private BigDecimal interestRate;

    @NotNull
    private Integer termMonths;

    @NotNull
    private LocalDate issueDate;
}