package csa.sber.service;

import csa.sber.entity.Credit;
import csa.sber.entity.PaymentSchedule;
import csa.sber.repository.PaymentScheduleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleGeneratorService {

    private final PaymentScheduleRepository repository;

    public List<PaymentSchedule> generate(Credit credit, BigDecimal annualRate, int termMonths, LocalDate startDate) {

        BigDecimal loanAmount = credit.getCreditAmount();
        BigDecimal monthlyRate = annualRate.divide(BigDecimal.valueOf(12), MathContext.DECIMAL64).divide(BigDecimal.valueOf(100), MathContext.DECIMAL64);
        BigDecimal annuityPayment = calculateAnnuityPayment(loanAmount, monthlyRate, termMonths);
        List<PaymentSchedule> schedule = new ArrayList<>();
        BigDecimal remainingDebt = loanAmount;
        for (int i = 1; i <= termMonths; i++) {
            BigDecimal interest = remainingDebt.multiply(monthlyRate);
            BigDecimal principal = annuityPayment.subtract(interest);
            remainingDebt = remainingDebt.subtract(principal);
            PaymentSchedule payment = PaymentSchedule.builder().credit(credit).paymentDate(startDate.plusMonths(i)).paymentAmount(annuityPayment).principalAmount(principal).interestAmount(interest).build();
            schedule.add(payment);
        }

        return repository.saveAll(schedule);
   }

    private BigDecimal calculateAnnuityPayment(BigDecimal amount, BigDecimal monthlyRate, int months) {
        BigDecimal onePlusRate = BigDecimal.ONE.add(monthlyRate);
        BigDecimal pow = onePlusRate.pow(months);
        BigDecimal numerator = amount.multiply(monthlyRate).multiply(pow);
        BigDecimal denominator = pow.subtract(BigDecimal.ONE);
        return numerator.divide(denominator, MathContext.DECIMAL64);
   }
}