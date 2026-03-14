package csa.sber.dto.credit;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
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
    @Digits(integer = 12, fraction = 0)
    private Long dealNumber;

    @NotNull
    private BigDecimal interestRate;

    @NotNull
    private Integer termMonths;

    @NotNull
    private LocalDate issueDate;
}