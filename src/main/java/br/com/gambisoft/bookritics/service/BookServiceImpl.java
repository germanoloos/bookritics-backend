package br.com.gambisoft.bookritics.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gambisoft.bookritics.model.Book;
import br.com.gambisoft.bookritics.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book findByName(String name) {
		return this.bookRepository.findByName(name);
	}

	@Override
	public Book createNewBook(Book book) {
		return this.bookRepository.insert(book);
	}

	@Override
	public List<Book> findAll() {
		return this.bookRepository.findAll();
	}

	@Override
	public Optional<Book> findByIdl(String id) {
		return this.bookRepository.findById(id);
	}

	@Override
	public void delete(String id) {
		this.bookRepository.deleteById(id);;

	}

}
