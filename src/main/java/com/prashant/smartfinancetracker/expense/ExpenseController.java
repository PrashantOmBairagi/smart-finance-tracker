package com.prashant.smartfinancetracker.expense;

import com.prashant.smartfinancetracker.auth.AuthService;
import com.prashant.smartfinancetracker.user.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;
    private final AuthService authService;

    @PostMapping
    public ResponseEntity<?> createExpense(@Valid @RequestBody ExpenseRequest expenseRequest) {
        User currentUser = authService.getCurrentUser();
        expenseService.createExpense(expenseRequest, currentUser);
        return new ResponseEntity<>("Kharcha Saved!",HttpStatus.ACCEPTED);
    }

    @GetMapping
    public List<ExpenseResponse> getAllExpenses()
    {
        User currentUser = authService.getCurrentUser();
        List<Expense> expenses = expenseService.findAllExpenses(currentUser);
        return expenses.stream()
                .map(expense -> new ExpenseResponse(
                        expense.getId(),
                        expense.getDescription(),
                        expense.getAmount(),
                        expense.getCategory(),
                        expense.getExpenseDate(),
                        expense.getUser() != null ? expense.getUser().getId() : null
                ))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ExpenseResponse getExpenseById(@NotNull @PathVariable long id)
    {
        User currentUser = authService.getCurrentUser();
        Expense expense = expenseService.findExpenseById(id,currentUser);
        return new ExpenseResponse(expense.getId(),
                expense.getDescription(),
                expense.getAmount(),
                expense.getCategory(),
                expense.getExpenseDate(),
                expense.getUser() != null ? expense.getUser().getId() : null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateExpense(@NotNull @PathVariable Long id , @Valid @RequestBody ExpenseUpdateRequest request){
        User currentUser = authService.getCurrentUser();
        expenseService.updateExpense(id,request,currentUser);
        return new ResponseEntity<>("Expense Updated Successfully",HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpenseById(@NotNull @PathVariable Long id) {
        User currentUser = authService.getCurrentUser();
        return expenseService.deleteExpenseById(id,currentUser);
    }





}
