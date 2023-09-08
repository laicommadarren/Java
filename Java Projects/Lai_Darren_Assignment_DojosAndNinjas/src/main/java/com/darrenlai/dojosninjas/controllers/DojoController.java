package com.darrenlai.dojosninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.darrenlai.dojosninjas.models.Dojo;
import com.darrenlai.dojosninjas.services.DojoService;

import jakarta.validation.Valid;

@Controller
public class DojoController {
	@Autowired
	DojoService dojoService;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	@GetMapping("/dojos/new")
	public String createDojo(@ModelAttribute("dojo") Dojo dojo, Model model) {
		
		return "dojosninjas/newDojo.jsp";
	}
	@PostMapping("/dojos/new")
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if (result.hasErrors()) {
        	List<Dojo> dojos = dojoService.allDojos();
        	model.addAttribute("dojos", dojos);
            return "dojosninjas/newDojo.jsp";
        } else {
            dojoService.createDojo(dojo);
            return "redirect:/";
        }
	}
	@GetMapping("/dojos/{id}")
	public String showDojoWithNinjas(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "dojosninjas/oneDojoWithNinjas.jsp";
	}
}