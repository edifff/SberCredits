package csa.sber.repository;

import csa.sber.entity.PaymentSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PaymentScheduleRepository extends JpaRepository<PaymentSchedule, Long> {

    List<PaymentSchedule> findByCreditDealNumberAndPaymentDateBefore(Long dealId, LocalDate date);

    List<PaymentSchedule> findByCreditDealNumberAndPaymentDateBetween(Long dealId, LocalDate start, LocalDate end);
}
