package com.usjt.beehealthy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usjt.beehealthy.model.User;
import com.usjt.beehealthy.service.UserService;

@RestController
@RequestMapping("user")
public class AccountController {
	
	@Autowired
	UserService userService; 
	
	@PostMapping("/register")
	public User register(User user) {
		try {
			return userService.register(user);			
		}catch(Exception e) {
			throw e;
		}
	}
	
	@PostMapping("/login")
	public User login(User user) {
		User foundUser = userService.login(user);
		if (foundUser!= null) {
			return foundUser;
		}else {
			return foundUser;
		}
	}
	
}	
