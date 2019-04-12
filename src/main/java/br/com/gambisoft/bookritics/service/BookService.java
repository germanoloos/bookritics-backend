package br.com.gambisoft.bookritics.service;

import java.util.List;
import java.util.Optional;

import br.com.gambisoft.bookritics.model.Book;

public interface BookService {
	
	Book findByName(String name);
	Book createNewBook(Book book);
	List<Book> findAll();
	Optional<Book>  findByIdl(String id);
	void delete (String id);
}
