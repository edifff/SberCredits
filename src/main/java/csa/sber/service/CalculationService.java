package csa.sber.service;

import csa.sber.dto.CalculationRequestDTO;
import csa.sber.dto.CalculationResponseDTO;
import csa.sber.entity.Credit;
import csa.sber.entity.PaymentSchedule;
import csa.sber.repository.CreditRepository;
import csa.sber.repository.PaymentScheduleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class CalculationService {
    private final CreditRepository creditRepository;
    private final PaymentScheduleRepository scheduleRepository;

    public CalculationResponseDTO calculate(CalculationRequestDTO request) {


        Credit credit = creditRepository.findById(request.getDealId())
                .orElseThrow(() -> new EntityNotFoundException("Credit not found"));

        LocalDate date = request.getCalculationDate();

        List<PaymentSchedule> pastPayments = scheduleRepository.findByCreditDealIDAndPaymentAmountDateBefore(request.getDealId(), date);
        BigDecimal paid = pastPayments.stream().map(PaymentSchedule::getPrincipalAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal balanceOnDate = credit.getCreditAmount().subtract(paid);
        LocalDate oneYearLater = date.plusYears(1);
        List<PaymentSchedule> futurePayments = scheduleRepository.findByCreditDealIDBetween(request.getDealId(), date, oneYearLater);
        BigDecimal paidNextYear = futurePayments.stream()
                .map(PaymentSchedule::getPrincipalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal balanceInYear = balanceOnDate.subtract(paidNextYear);

        return CalculationResponseDTO.builder()
                .dealId(credit.getDealID())
                .creditAmount(credit.getCreditAmount())
                .balanceOnDate(balanceOnDate)
                .balanceInOneYear(balanceInYear)
                .build();
    }
}
