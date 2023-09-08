package com.darrenlai.bookclub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
//	@Autowired
//	private UserService userService;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
}