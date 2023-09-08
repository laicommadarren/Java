package com.darrenlai.loginreg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.darrenlai.loginreg.models.LoginUser;
import com.darrenlai.loginreg.models.User;
import com.darrenlai.loginreg.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LoginRegController {
    
     @Autowired
     private UserService userServ;
    
    @GetMapping("/")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "/loginreg/index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
        // TO-DO Later -- call a register method in the service 
        // to do some extra validations and create a new user!
    	userServ.register(newUser, result);
    	
        
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
        	// model.addAttribute("newUser", newUser);
            model.addAttribute("newLogin", new LoginUser());
            return "loginreg/index.jsp";
        }
        
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("currentUser", newUser.getId());
    
        return "redirect:/welcome";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        // Add once service is implemented:
        User user = userServ.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "loginreg/index.jsp";
        }
    
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("userId", user.getId());
        session.setAttribute("username", user.getUsername());
    
        return "redirect:/welcome";
    }
    
    @GetMapping("/welcome")
    public String welcome(HttpSession session) {
    	if (session.getAttribute("userId")== null) return "redirect:/";
    	return "loginreg/welcome.jsp";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.setAttribute("userId", null);
    	session.setAttribute("username", null);
    	return "redirect:/";
    }
    
}