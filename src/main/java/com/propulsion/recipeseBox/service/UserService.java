package com.propulsion.recipeseBox.service;

import java.util.List;

import com.propulsion.recipeseBox.domain.User;

public interface UserService {

	User save(User user);
	
	User findById(Long id);
	
	User findByUsername(String username);
	
	User findByEmail(String email);
	
	List<User> findAll();
}
