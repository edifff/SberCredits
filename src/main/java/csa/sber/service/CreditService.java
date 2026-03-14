package csa.sber.service;

import csa.sber.dto.credit.CreditRequestDTO;
import csa.sber.dto.credit.CreditResponseDTO;
import csa.sber.mapper.CreditMapper;
import csa.sber.repository.CreditRepository;
import csa.sber.entity.Credit;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class CreditService {

    private final ScheduleGeneratorService scheduleGenerator;
    private final CreditRepository creditRepository;
    private final CreditMapper mapper;

    public CreditResponseDTO create(CreditRequestDTO creditRequestDTO) {
        Credit credit = mapper.toEntity(creditRequestDTO);
        Credit saved = creditRepository.save(credit);
        scheduleGenerator.generate(saved, credit.getInterestRate(), credit.getTermMonths(), credit.getIssueDate());
        return mapper.toDTO(saved);
    }

    public CreditResponseDTO getById(Long id) {
        Credit credit = creditRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Credit not found"));
        return mapper.toDTO(credit);
    }

    public CreditResponseDTO update(Long id, CreditRequestDTO updateCredit) {
        Credit credit = creditRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Credit not found"));
        mapper.updateEntity(updateCredit, credit);
        Credit saved = creditRepository.save(credit);
        return mapper.toDTO(saved);
    }

    public void delete(Long id) {
        if (!creditRepository.existsById(id)) {
            throw new EntityNotFoundException("Credit not found");
        }
        creditRepository.deleteById(id);
    }
}
