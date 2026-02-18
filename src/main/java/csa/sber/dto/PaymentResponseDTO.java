package csa.sber.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
public class PaymentResponseDTO {

    private Long id;
    private Long creditId;
    private LocalDate paymentDate;
    private BigDecimal paymentAmount;
}
