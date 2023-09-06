package com.darrenlai.burgers.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.darrenlai.burgers.models.Burger;
import com.darrenlai.burgers.services.BurgerService;

import jakarta.validation.Valid;
@Controller
public class BurgerController {
	@Autowired
	BurgerService burgerService;
	
	
    @GetMapping("/")
    public String index(@ModelAttribute("burger") Burger burger, Model model) {
    	List<Burger> burgers = burgerService.allBurgers();
    	model.addAttribute("burgers", burgers);
    	return "index.jsp";
    }
    @PostMapping("/burgers/new")
    public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	List<Burger> burgers = burgerService.allBurgers();
        	model.addAttribute("burgers", burgers);
            return "index.jsp";
        } else {
            burgerService.createBurger(burger);
            return "redirect:/";
        }
    }
    @GetMapping("/burgers/edit/{id}")
    public String editPage(Model model, @PathVariable("id") Long id, @ModelAttribute("burger") Burger burger) {
    		model.addAttribute("burger", burgerService.findBurger(id));
            return "burger/edit.jsp";
    	}
    @PutMapping("/burgers/edit/{id}/submit")
    public String editSubmit(@Valid @ModelAttribute("burger") Burger burger, BindingResult result,
    		@PathVariable("id") Long id) {
    	if (result.hasErrors()) {
            return "burger/edit.jsp";
    	} else {
    		burgerService.updateBurger(burger);
    		return "redirect:/";
    	}
    }
}