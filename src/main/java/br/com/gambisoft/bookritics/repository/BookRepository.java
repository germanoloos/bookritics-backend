package br.com.gambisoft.bookritics.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.gambisoft.bookritics.model.Book;

public interface BookRepository extends MongoRepository<Book, String> {
	
	Book findByName(String name);

}
