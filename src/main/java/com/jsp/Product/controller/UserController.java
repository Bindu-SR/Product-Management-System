package com.jsp.Product.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.jsp.Product.entity.User;
import com.jsp.Product.service.UserService;
import com.jsp.Product.utility.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class UserController {

	private UserService service;
	
	public UserController(UserService service) {
		super();
		this.service = service;
	}
    
	@PostMapping(value = "/users")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody @Valid User user) {
		return service.saveUser(user);
	}
}
