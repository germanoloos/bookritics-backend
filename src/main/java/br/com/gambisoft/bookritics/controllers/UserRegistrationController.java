package br.com.gambisoft.bookritics.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.gambisoft.bookritics.model.User;
import br.com.gambisoft.bookritics.service.UserService;

@Controller
public class UserRegistrationController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST, value = "/register/user")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public User registerUser(@RequestBody User user) {
		return userService.createNewUser(user);
	}
}
