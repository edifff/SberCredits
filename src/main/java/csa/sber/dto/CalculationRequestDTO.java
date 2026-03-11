package csa.sber.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CalculationRequestDTO {

    @NotNull
    private Long dealId;

    @NotNull
    private LocalDate calculationDate;
}
