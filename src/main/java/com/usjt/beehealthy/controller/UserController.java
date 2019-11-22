package com.usjt.beehealthy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.usjt.beehealthy.model.User;
import com.usjt.beehealthy.service.UserService;
import com.usjt.beehealthy.service.UserService.UserNotFound;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService userService; 
	
	@PostMapping("/register")
	@ResponseStatus(code=HttpStatus.CREATED)
	public @ResponseBody Object register(@RequestBody Object user) {
		try {
			return userService.register(user);			
		}catch(Exception e) {
			throw e;
		}
	}
	
	@PostMapping("/login")
	@ResponseStatus(code=HttpStatus.OK)
	public @ResponseBody Object login(@RequestBody User user) throws UserNotFound {
		try {
			return userService.login(user);
			
		}catch(Exception e) {
			throw e;
		}
		
	}
	
}	
