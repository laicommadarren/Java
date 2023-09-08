package com.darrenlai.dojosninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.darrenlai.dojosninjas.models.Dojo;
import com.darrenlai.dojosninjas.models.Ninja;
import com.darrenlai.dojosninjas.services.NinjaService;
import com.darrenlai.dojosninjas.services.DojoService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
	@Autowired
	NinjaService ninjaService;
	@Autowired
	DojoService dojoService;
	
	@GetMapping("/ninjas/new")
	public String createNinja(@ModelAttribute("ninja") Ninja ninja,
			Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "dojosninjas/newNinja.jsp";
	}
	@PostMapping("/ninjas/new")
	public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if (result.hasErrors()) {
        	List<Ninja> ninjas = ninjaService.allNinjas();
        	model.addAttribute("ninjas", ninjas);
        	List<Dojo> dojos = dojoService.allDojos();
    		model.addAttribute("dojos", dojos);
            return "dojosninjas/newNinja.jsp";
        } else {
            ninjaService.createNinja(ninja);
            return "redirect:/";
        }
	}
}