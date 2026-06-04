package com.prashant.smartfinancetracker.auth;


import com.prashant.smartfinancetracker.expense.Expense;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RequiredArgsConstructor
@RestController("/api/v1/auth")
public class AuthController {

    public ResponseEntity<?> register(@Valid @RequestBody Expense expense) {
        return null; //for now
    }
}
