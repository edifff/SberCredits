package csa.sber.dto.payment;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class PaymentRequestDTO {

    @NotNull
    private LocalDate paymentDate;
    @NotNull
    @DecimalMin("0.01")
    private BigDecimal paymentAmount;
}
