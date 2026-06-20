package com.prashant.smartfinancetracker.expense;

import com.prashant.smartfinancetracker.enums.ExpenseCategory;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UUID;

import java.math.BigDecimal;
import java.time.LocalDate;
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExpenseUpdateRequest {
    private UUID id;

    @Length(max = 100)
    private String description;

    @Positive(message = "Amount must be positive.")
    private BigDecimal amount;

    private ExpenseCategory category ;

    @PastOrPresent(message = "Expense cannot have future date.")
    private LocalDate expenseDate;
}
