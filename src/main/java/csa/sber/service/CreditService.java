package csa.sber.service;

import csa.sber.dto.CreditRequestDTO;
import csa.sber.dto.CreditResponseDTO;
import csa.sber.mapper.CreditMapper;
import csa.sber.repository.CreditRepository;
import csa.sber.entity.Credit;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreditService {
    private CreditRepository creditRepository;
    private CreditMapper mapper;

    @Autowired
    public CreditService(CreditRepository creditRepository, CreditMapper mapper) {
        this.creditRepository = creditRepository;
        this.mapper = mapper;
    }

    public CreditResponseDTO create(CreditRequestDTO creditRequestDTO) {
        Credit credit = mapper.toEntity(creditRequestDTO);
        Credit saved = creditRepository.save(credit);
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
