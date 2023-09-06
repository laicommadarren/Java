package com.darrenlai.omikuji.controllers;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class OmikujiController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/omikuji")
	public String omikuji() {
		return "omikuji.jsp";
	}
	
	@PostMapping("/omikuji/submit")
	public String submitOmikuji(HttpSession session,
		@RequestParam(value="number") Integer number,
		@RequestParam(value="person") String person,
		@RequestParam(value="endeavor") String endeavor,
		@RequestParam(value="livingThing") String livingThing,
		@RequestParam(value="niceMessage") String niceMessage) {
		session.setAttribute("number", number);
		session.setAttribute("person", person);
		session.setAttribute("endeavor", endeavor);
		session.setAttribute("livingThing", livingThing);
		session.setAttribute("niceMessage", niceMessage);
		
		return "redirect:/omikuji/show";
	}
	
	@GetMapping("/omikuji/show")
	public String showOmikuji(Model model, HttpSession session) {
		Integer number = (Integer) session.getAttribute("number");
		String person = (String) session.getAttribute("person");
		String endeavor = (String) session.getAttribute("endeavor");
		String livingThing = (String) session.getAttribute("livingThing");
		String niceMessage = (String) session.getAttribute("niceMessage");
		
		model.addAttribute("number", number);
		model.addAttribute("person", person);
		model.addAttribute("endeavor", endeavor);
		model.addAttribute("livingThing", livingThing);
		model.addAttribute("niceMessage", niceMessage);
		return "showomikuji.jsp";
	}
	
}