package com.prashant.smartfinancetracker.expense;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping
    public Expense save(@Valid @RequestBody Expense expense) {
        expenseService.save(expense);
        return expense;
    }

    @GetMapping("/get")
    public List<Expense> getAllExpenses()
    {
        return expenseService.findAllExpenses();
    }

    @GetMapping("/get/{id}")
    public Expense getExpenseById(@NotNull @PathVariable long id)
    {
        return expenseService.findExpenseById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateExpense(@NotNull @PathVariable Long id , @Valid @RequestBody Expense expense){
        expense.setId(id);
        expenseService.save(expense);
        return new ResponseEntity<>("Expense Deleted Successfully",HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteExpenseById(@NotNull @PathVariable Long id) {
        return expenseService.deleteExpenseById(id);
    }





}
