package csa.sber.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "credits")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deal_id", nullable = false)
    private Long dealID;

    @Column(name = "dealNumber", nullable = false, unique = true)
    private String dealNumber;

    @Column(name = "credit_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal creditAmount;

    @Column(name = "interest_rate", nullable = false, precision = 5, scale = 2)
    private BigDecimal interestRate;

    @Column(name = "term_months", nullable = false)
    private Integer termMonths;

    @Column(name = "issue_date", nullable = false)
    private LocalDate issueDate;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "credit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> payments = new ArrayList<>();

    @OneToMany(mappedBy = "credit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PaymentSchedule> schedule = new ArrayList<>();
}