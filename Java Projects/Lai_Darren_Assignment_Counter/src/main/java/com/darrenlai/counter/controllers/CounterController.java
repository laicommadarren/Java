package com.darrenlai.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
@Controller
public class CounterController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		Integer count = 0;
    	// If the count is not already in session
		if (session.getAttribute("count") == null) {
		// Use setAttribute to initialize the count in session
			session.setAttribute("count", 0);
		}
		else {
		// increment the count by 1 using getAttribute and setAttribute
			count = (Integer) session.getAttribute("count") + 1;
			session.setAttribute("count", count);
		}
		return "index.jsp";
    }
	@RequestMapping("/counter")
	public String counter() {
		return "counter.jsp";
	}
}