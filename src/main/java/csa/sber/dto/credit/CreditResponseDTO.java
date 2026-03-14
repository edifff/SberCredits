package csa.sber.dto.credit;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
public class CreditResponseDTO {

    private Long dealNumber;

    private BigDecimal creditAmount;

    private BigDecimal interestRate;

    private Integer termMonths;

    private LocalDate issueDate;

    private LocalDateTime createdAt;
}