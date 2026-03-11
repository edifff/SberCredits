package csa.sber.repository;

import csa.sber.entity.PaymentSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public interface PaymentScheduleRepository extends JpaRepository<PaymentSchedule, Long> {

    List<PaymentSchedule> findByCreditDealIDAndPaymentAmountDateBefore(
            Long dealId,
            LocalDate date
    );

    List<PaymentSchedule> findByCreditDealIDBetween(
            Long dealId,
            LocalDate start,
            LocalDate end
    );
}
