package csa.sber.dto;

import jakarta.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreditReqestDTO {

    @NonNull
    @DecimalMin("0.01")
    private BigDecimal creditAmount;
}
