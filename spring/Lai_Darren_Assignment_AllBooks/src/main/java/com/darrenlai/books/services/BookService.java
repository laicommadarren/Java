package com.darrenlai.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.darrenlai.books.models.Book;
import com.darrenlai.books.repositories.BookRepository;
@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
	public Book updateBook(String title, String desc, String lang, Integer numOfPages, Long id) {
		Optional<Book> book = bookRepository.findById(id);
		Book bookToUpdate = book.get();
		bookToUpdate.setTitle(title);
		bookToUpdate.setDescription(desc);
		bookToUpdate.setLanguage(lang);
		bookToUpdate.setNumberOfPages(numOfPages);
		return bookRepository.save(bookToUpdate);
	}
	public void deleteBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
        	bookRepository.deleteById(id);
        }
    }
	
}