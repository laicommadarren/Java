package com.darrenlai.books.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.darrenlai.books.models.Book;
import com.darrenlai.books.repositories.BookRepository;
import com.darrenlai.books.services.BookService;


@Controller
public class BookController {
	private final BookRepository bookRepository;
	private final BookService bookService;
	public BookController(BookRepository bookRepository, BookService bookService){
	        this.bookRepository = bookRepository;
	        this.bookService = bookService;
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
	
	@RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "/books/index.jsp";
    }
}