package br.com.gambisoft.bookritics.service;

import java.util.List;

import br.com.gambisoft.bookritics.model.User;

public interface UserService {
	
	public User createNewUser(User user);
	
	public List<User> findAll();
	
	public Float getRating(String bookId);
}
