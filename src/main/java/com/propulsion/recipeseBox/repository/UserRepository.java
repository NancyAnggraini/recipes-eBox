package com.propulsion.recipeseBox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.propulsion.recipeseBox.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	//NOT NEEDED (TAKEN CARE BY JPA)
//	@SuppressWarnings("unchecked")
//	User save(User user);
	
	// Find by user.id
	User findById(Long id);
	
	// Find by user.username
	User findByUsername(String username);
	
	// Find by user.email
	User findByEmail(String email);
	
}

