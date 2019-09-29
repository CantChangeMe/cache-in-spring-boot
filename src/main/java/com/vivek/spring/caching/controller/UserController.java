package com.vivek.spring.caching.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.spring.caching.model.User;
import com.vivek.spring.caching.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		
		this.userService = userService;
	}
	
	@GetMapping("/all")
	public List<User> getAllUsers(){
		
		return userService.findAll();
	}
	
	@PostMapping("/update")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
}
