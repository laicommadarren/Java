package com.darrenlai.savetravels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.darrenlai.savetravels.models.Expense;
import com.darrenlai.savetravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
public class ExpenseController {
	@Autowired
	ExpenseService expenseService;
	
	
    @GetMapping("/")
    public String index() {
    	return "expenses/index.jsp";
    }
    @GetMapping("/expenses")
    public String expenseHome(@ModelAttribute("expense") Expense expense, Model model) {
    	List<Expense> expenses = expenseService.allExpenses();
    	model.addAttribute("expenses", expenses); 
    	return "expenses/expense.jsp";
    }
    @PostMapping("/expenses/new")
    public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	List<Expense> expenses = expenseService.allExpenses();
        	model.addAttribute("expenses", expenses);
            return "expenses/expense.jsp";
        } else {
            expenseService.createExpense(expense);
            return "redirect:/expenses";
        }
    }
    @GetMapping("/expenses/{id}")
    public String viewExpense(Model model, @PathVariable("id") Long id, @ModelAttribute("expense") Expense expense) {
    	model.addAttribute("expense", expenseService.findExpense(id));
    	return "expenses/viewOne.jsp";
    }
    
    @GetMapping("/expenses/edit/{id}")
    public String editPage(Model model, @PathVariable("id") Long id, @ModelAttribute("expense") Expense expense) {
    		model.addAttribute("expense", expenseService.findExpense(id));
            return "expenses/edit.jsp";
    	}
    @PutMapping("/expenses/edit/{id}/submit")
    public String editSubmit(@Valid @ModelAttribute("expense") Expense expense, BindingResult result,
    		@PathVariable("id") Long id) {
    	if (result.hasErrors()) {
            return "expenses/edit.jsp";
    	} else {
    		expenseService.updateExpense(expense);
    		return "redirect:/expenses";
    	}
    }
    @DeleteMapping("/expenses/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses";
    }
}