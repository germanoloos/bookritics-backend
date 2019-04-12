package br.com.gambisoft.bookritics.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.gambisoft.bookritics.service.BookService;

@Controller
public class BookDeleteController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping(method = RequestMethod.PUT, value = "/delete/book")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public void updateStudentRecord(@PathVariable("id") String id) {
		bookService.delete(id);
	}

}
