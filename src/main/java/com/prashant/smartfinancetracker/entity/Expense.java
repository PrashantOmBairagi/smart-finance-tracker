package com.prashant.smartfinancetracker.entity;

import com.prashant.smartfinancetracker.enums.ExpenseCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "expenses")
public class Expense {
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

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

//    @Getter
//    @Setter
//    private int userId;

}
