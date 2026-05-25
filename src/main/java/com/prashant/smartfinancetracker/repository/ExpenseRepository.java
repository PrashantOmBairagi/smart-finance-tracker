package com.prashant.smartfinancetracker.repository;

import com.prashant.smartfinancetracker.entity.Expense;
import org.springframework.data.repository.CrudRepository;

public abstract class ExpenseRepository implements CrudRepository<Expense,String> {
}
