package br.com.gambisoft.bookritics.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.gambisoft.bookritics.model.Book;
import br.com.gambisoft.bookritics.service.BookService;
import br.com.gambisoft.bookritics.service.UserService;

@Controller
public class BookRetrieveController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET, value = "/book/allbooks")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public List<Book> getAllBooks() {
		List<Book> books = bookService.findAll();
		return books;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/book/rating")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public Book[] getRatings() {
		
		List<Book> books = bookService.findAll();
		for(Book book: books) {
			book.setRating(userService.getRating(book.getId()));
		}
		Book [] booksArray = new Book[books.size()];
		booksArray = books.toArray(booksArray);
		Arrays.sort(booksArray);
		
		return booksArray;
	}

}
