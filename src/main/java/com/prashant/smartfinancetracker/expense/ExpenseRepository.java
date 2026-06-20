package com.prashant.smartfinancetracker.expense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    public List<Expense> findByUserId(UUID id);
    public Optional<Expense> findByIdAndUserId(Long id, UUID userId);
}
