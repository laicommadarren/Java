package com.darrenlai.savetravels.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.darrenlai.savetravels.models.*;
import com.darrenlai.savetravels.repositories.*;
@Service
public class ExpenseService {
    // adding the Burger repository as a dependency
    private final ExpenseRepo expenseRepo;
    
    public ExpenseService(ExpenseRepo expenseRepo) {
        this.expenseRepo = expenseRepo;
    }
    public List<Expense> allExpenses() {
        return expenseRepo.findAll();
    }
    // creates a Burger
    public Expense createExpense(Expense expense) {
        return expenseRepo.save(expense);
    }
    // retrieves a Burger
    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepo.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
    public Expense updateExpense(Expense expense) {
    	return expenseRepo.save(expense);
    }
	public void deleteExpense(Long id) {
            expenseRepo.deleteById(id);
        }
}
