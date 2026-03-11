package csa.sber.controllers;

import csa.sber.dto.CalculationRequestDTO;
import csa.sber.dto.CalculationResponseDTO;
import csa.sber.service.CalculationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sber/calculate")
@AllArgsConstructor
public class CalculationController {

    private final CalculationService calculationService;

    @PostMapping
    public CalculationResponseDTO calculate(@Valid @RequestBody CalculationRequestDTO request) {
        return calculationService.calculate(request);
    }
}
