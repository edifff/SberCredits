package csa.sber.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
public class CreditResponseDTO {

    private Long dealID;
    private BigDecimal creditAmount;
    private LocalDateTime createdAt;
}
