package csa.sber.service;

import csa.sber.dto.CalculationRequestDTO;
import csa.sber.dto.CalculationResponseDTO;
import csa.sber.entity.Credit;
import csa.sber.entity.PaymentSchedule;
import csa.sber.entity.enums.Currency;
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
    private final CurrencyService currencyService;

    public CalculationResponseDTO calculate(CalculationRequestDTO request) {

        Credit credit = creditRepository.findByDealNumber(request.getDealNumber())
                .orElseThrow(() -> new EntityNotFoundException("Credit not found"));

        LocalDate date = request.getCalculationDate();

        List<PaymentSchedule> pastPayments =
                scheduleRepository.findByCreditDealNumberAndPaymentDateBefore(
                        request.getDealNumber(), date);

        BigDecimal paid = pastPayments.stream()
                .map(PaymentSchedule::getPrincipalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal balanceOnDate =
                credit.getCreditAmount().subtract(paid);

        LocalDate oneYearLater = date.plusYears(1);

        List<PaymentSchedule> futurePayments =
                scheduleRepository.findByCreditDealNumberAndPaymentDateBetween(
                        request.getDealNumber(), date, oneYearLater);

        BigDecimal paidNextYear = futurePayments.stream()
                .map(PaymentSchedule::getPrincipalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal balanceInYear =
                balanceOnDate.subtract(paidNextYear);

        Currency target = request.getTargetCurrency();

        return CalculationResponseDTO.builder()
                .dealNumber(credit.getDealNumber())

                .creditAmount(currencyService.convertFromRub(credit.getCreditAmount(), target))
                .creditAmountCurrency(target)

                .balanceOnDate(currencyService.convertFromRub(balanceOnDate, target))
                .balanceOnDateCurrency(target)

                .balanceInOneYear(currencyService.convertFromRub(balanceInYear, target))
                .balanceInOneYearCurrency(target)

                .build();
    }
}
