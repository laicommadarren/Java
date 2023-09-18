package com.darrenlai.bookclub.controllers;

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

import com.darrenlai.bookclub.models.Book;
import com.darrenlai.bookclub.services.BookService;
import com.darrenlai.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/books")
    public String welcome(HttpSession session, Model model) {
    	Long id = (Long) session.getAttribute("userId");
		if (id == null) return "redirect:/";
    	model.addAttribute("user", userService.findUser(id));
    	model.addAttribute("books", bookService.allBooks());
    	return "bookclub/books.jsp";
    }
    
    @GetMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book, Model model, HttpSession session) {
    	Long userId = (Long) session.getAttribute("userId");
    	model.addAttribute("userId", userId);
    	return "bookclub/newBook.jsp";
    }
    
    @PostMapping("/books/new")
	public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
            return "bookclub/newBook.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
	}
    
    @GetMapping("/books/{id}")
    public String addBook(@PathVariable Long id, Model model) {
    	Book book = bookService.findBook(id);
    	model.addAttribute("book", book);
    	
    	return "bookclub/showBook.jsp";
    }
    @GetMapping("/books/{id}/edit")
    public String editBook(Model model, @PathVariable("id") Long id) {
    	model.addAttribute("book", bookService.findBook(id));
    	return "bookclub/editBook.jsp";
    }
    @PutMapping("/books/{id}/edit")
    public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result,
    		@PathVariable("id") Long id) {
    	if (result.hasErrors()) {
            return "bookclub/editBook.jsp";
    	} else {
    		bookService.updateBook(book);
    		return "redirect:/books";
    	}
    }
    @DeleteMapping("/books/{id}/delete")
    public String destroyBook(@PathVariable("id") Long id) {
        bookService.deleteExpense(id);
        return "redirect:/books";
    }

}