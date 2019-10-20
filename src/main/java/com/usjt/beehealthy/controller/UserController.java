package com.usjt.beehealthy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.usjt.beehealthy.model.User;
import com.usjt.beehealthy.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService userService; 
	
	@PostMapping("/register")
	public @ResponseBody Object register(@RequestBody Object user) {
		try {
			return userService.register(user);			
		}catch(Exception e) {
			throw e;
		}
	}
	
	@PostMapping("/login")
	public @ResponseBody Object login(@RequestBody User user) {
		Object foundUser = userService.login(user);
		return foundUser;
	}
	
}	
