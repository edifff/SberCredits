package csa.sber.controllers;

import csa.sber.dto.CreditReqestDTO;
import csa.sber.dto.CreditResponseDTO;
import csa.sber.service.CreditService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sber/credit")
public class CreditController {

    private final CreditService creditService;


    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreditResponseDTO create(@Valid @RequestBody CreditReqestDTO creditReqestDTO){
        return creditService.create(creditReqestDTO);
    }

    @GetMapping("/{id}")
    public CreditResponseDTO get(@PathVariable Long id){
        return creditService.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        creditService.delete(id);
    }

    @PatchMapping("/{id}")
    public CreditResponseDTO update(@PathVariable Long id, @Valid @RequestBody CreditReqestDTO creditReqestDTO){
        return creditService.update(id, creditReqestDTO);
    }

}
