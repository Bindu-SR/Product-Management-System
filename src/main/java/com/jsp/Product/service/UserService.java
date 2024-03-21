package com.jsp.Product.service;

import org.springframework.http.ResponseEntity;
import com.jsp.Product.entity.User;
import com.jsp.Product.utility.ResponseStructure;

public interface UserService {

	public ResponseEntity<ResponseStructure<User>> saveUser(User user);
}
