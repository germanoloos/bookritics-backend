package br.com.gambisoft.bookritics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gambisoft.bookritics.model.User;
import br.com.gambisoft.bookritics.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;


	@Override
	public User createNewUser(User user) {
		return this.userRepository.insert(user);
	}


	@Override
	public List<User> findAll() {
		return this.userRepository.findAll();
	}


	@Override
	public Float getRating(String bookId) {
		return this.userRepository.getRating(bookId);
	}

}
