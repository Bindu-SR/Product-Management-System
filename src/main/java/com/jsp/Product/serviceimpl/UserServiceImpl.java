package com.jsp.Product.serviceimpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.jsp.Product.entity.User;
import com.jsp.Product.repo.UserRepository;
import com.jsp.Product.service.UserService;
import com.jsp.Product.utility.ResponseStructure;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository repo;
	private ResponseStructure<User> structure;
	
	public UserServiceImpl(UserRepository repo, ResponseStructure<User> structure) {
		super();
		this.repo = repo;
		this.structure = structure;
	}

    @Override
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		User uniqueUser = repo.save(user);
		
		return ResponseEntity.ok(structure.setStatusCode(HttpStatus.OK.value())
				                          .setMessage("User Object Created!!")
				                          .setData(uniqueUser));
	}
}
