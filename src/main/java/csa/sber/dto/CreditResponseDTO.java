package csa.sber.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
public class CreditResponseDTO {

    private Long dealID;

    private BigDecimal creditAmount;

    private BigDecimal interestRate;

    private Integer termMonths;

    private LocalDate issueDate;

    private LocalDateTime createdAt;
}