package csa.sber.dto.payment;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
public class PaymentResponseDTO {

    private Long paymentNumber;
    private Long creditNumber;
    private LocalDate paymentDate;
    private BigDecimal paymentAmount;
}
