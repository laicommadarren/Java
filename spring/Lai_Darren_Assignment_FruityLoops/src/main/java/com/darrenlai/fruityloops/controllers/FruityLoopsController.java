package com.darrenlai.fruityloops.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.darrenlai.fruityloops.models.Item;

@Controller
public class FruityLoopsController {

	@RequestMapping("/")
    public String index(Model model) {
        
		 ArrayList<Item> fruits = new ArrayList<Item>();
	        fruits.add(new Item("Kiwi", 1.5));
	        fruits.add(new Item("Mango", 2.0));
	        fruits.add(new Item("Goji Berries", 4.0));
	        fruits.add(new Item("Guava", .75));
	        
	        // Add fruits your view model here
	        
        model.addAttribute("fruitList", fruits);
    
    	// Your code here! Add values to the view model to be rendered
    
        return "index.jsp";
    }
}