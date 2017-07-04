package com.propulsion.recipeseBox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.propulsion.recipeseBox.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@SuppressWarnings("unchecked")
	User save(User user);
	
	User findById(Long id);
	
	User findByUsername(String username);
	
	User findByEmail(String email);
	
}

//User has a list of recipes. What to do with them? => not handle it from here (segregate!)