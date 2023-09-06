package com.darrenlai.books.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.darrenlai.books.models.Book;
import com.darrenlai.books.repositories.BookRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class BookController {
	private final BookRepository bookRepository;
	 public BookController(BookRepository bookRepository){
	        this.bookRepository = bookRepository;
	    }
	
	@GetMapping("/books/{id}")
	public String showOne(Model model, @PathVariable("id") Long id) {
		Optional<Book> book = bookRepository.findById(id);
		Book currentBook = book.get();
		model.addAttribute("title", currentBook.getTitle());
		model.addAttribute("description", currentBook.getDescription());
		model.addAttribute("language", currentBook.getLanguage());
		model.addAttribute("numOfPages", currentBook.getNumberOfPages());
		return "show.jsp";
	}
}