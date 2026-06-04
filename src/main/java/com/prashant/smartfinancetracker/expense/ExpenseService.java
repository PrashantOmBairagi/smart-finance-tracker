package com.prashant.smartfinancetracker.expense;

import com.prashant.smartfinancetracker.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void save(Expense expense) {
        expense.setCreatedAt(LocalDateTime.now());
        expenseRepository.save(expense);
    }

    public List<Expense> findAllExpenses() {
        return expenseRepository.findAll();
    }
    public ResponseEntity<String> deleteExpenseById(Long id) {
        if (!expenseRepository.existsById(id)) {
            throw new ResourceNotFoundException("Expense not found");
        }
        expenseRepository.deleteById(id);
        return new ResponseEntity<>("Expense deleted", HttpStatus.OK);
    }
}
