package com.darrenlai.events.controllers;

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

import com.darrenlai.events.models.Event;
import com.darrenlai.events.models.User;
import com.darrenlai.events.services.EventService;
import com.darrenlai.events.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class EventController {
	@Autowired
	private EventService eventService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/events")
    public String welcome(HttpSession session, Model model) {
    	Long id = (Long) session.getAttribute("userId");
		if (id == null) return "redirect:/";
    	model.addAttribute("user", userService.findUser(id));
    	model.addAttribute("events", eventService.allEvents());
    	model.addAttribute("userId", id);
    	model.addAttribute("event", new Event());
    	return "events/events.jsp";
    }
	
	@PostMapping("/events/add")
	public String newEvent(@ModelAttribute("event") Event event, BindingResult result) {
           eventService.createEvent(event);
		return "redirect:/events";
	}
//	@PostMapping("/events/{id}/join")
//	public String join(@ModelAttribute("event") Event event, @ModelAttribute("user") User user) {
//		event.getUsers().add(user)// .add() is a boolean so how do I set it?
//		event.setUsers(event.getUsers().add(User user));
//		eventService.updateEvent(event);
//		return "redirect:/events";
//	}

}