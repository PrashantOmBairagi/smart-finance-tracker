package com.prashant.smartfinancetracker.expense;
import com.prashant.smartfinancetracker.enums.ExpenseCategory;
import com.prashant.smartfinancetracker.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "expenses")
@NoArgsConstructor
public class Expense {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_username")
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String description;

    @Column(precision = 10, scale = 2)
    @NotNull
    @Positive(message = "Amount must be positive.")
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Category is required.")
    private ExpenseCategory category ;

    @NotNull(message = "Expense date is required.")
    @PastOrPresent(message = "Expense cannot have future date.")
    private LocalDate expenseDate;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
