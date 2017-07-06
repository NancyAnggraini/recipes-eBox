package com.propulsion.recipeseBox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.propulsion.recipeseBox.domain.User;
import com.propulsion.recipeseBox.repository.UserRepository;

@Service
@Transactional
public class DefaultUserService implements UserService {

	private final UserRepository userRepository;
	
	@Autowired
	public DefaultUserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User save(User user) {
		// Make sure we are saving a new user and not accidentally updating an existing user.
		user.setId(null);

		// A new user cannot have recipes before the account exists.
		user.getRecipes().clear();

		return this.userRepository.save(user);
	}

	@Override
	public User findById(Long id) {
		return this.userRepository.findById(id);
	}

	@Override
	public User findByUsername(String username) {
		return this.userRepository.findByUsername(username);
	}

	@Override
	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}

	@Override
	public List<User> findAll() {
		return this.userRepository.findAll();
	}

}
