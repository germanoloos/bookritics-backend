package br.com.gambisoft.bookritics.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.gambisoft.bookritics.model.User;

public interface UserRepository extends MongoRepository<User, String>, UserRepositoryCustom {

}
