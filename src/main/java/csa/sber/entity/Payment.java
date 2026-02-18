package csa.sber.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentId;

    @ManyToOne
    @JoinColumn(name = "deal_id", nullable = false)
    private Credit credit;

    @Column(name = "payment_date", nullable = false,insertable = false, updatable = false)
    private LocalDate paymantDate;

    @Column(name = "payment_amount", nullable = false)
    private BigDecimal paymantAmout;

    @Column(name = "created_at",insertable = false, updatable = false)
    private LocalDateTime createdAt;
}
