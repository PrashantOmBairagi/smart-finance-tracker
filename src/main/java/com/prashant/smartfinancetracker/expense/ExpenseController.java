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
    public List<Expense> getAllExpenses()
    {
        User currentUser = authService.getCurrentUser();
        return expenseService.findAllExpenses(currentUser);
    }

    @GetMapping("/{id}")
    public Expense getExpenseById(@NotNull @PathVariable long id)
    {
        User currentUser = authService.getCurrentUser();
        return expenseService.findExpenseById(id,currentUser);
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
