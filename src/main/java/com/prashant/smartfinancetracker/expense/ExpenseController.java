package com.prashant.smartfinancetracker.expense;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/expense")
public class ExpenseController {

    private final ExpenseService expenseService;
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public Expense save(@Valid @RequestBody Expense expense) {
        expenseService.save(expense);
        return expense;
    }

    @GetMapping
    public List<Expense> getAllExpenses()
    {
        return expenseService.findAllExpenses();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpenseById(@NotNull @PathVariable Long id) {
        return expenseService.deleteExpenseById(id);
    }





}
