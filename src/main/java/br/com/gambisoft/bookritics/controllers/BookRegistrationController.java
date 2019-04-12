package br.com.gambisoft.bookritics.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.gambisoft.bookritics.model.Book;
import br.com.gambisoft.bookritics.service.BookService;

@Controller
public class BookRegistrationController {
	
	@Autowired
	private BookService bookService;

	@RequestMapping(method = RequestMethod.POST, value = "/register/book")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public Book registerStudent(@RequestBody Book book) {
		return bookService.createNewBook(book);
	}
}
