package com.propulsion.recipeseBox.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.propulsion.recipeseBox.domain.Recipe;
import com.propulsion.recipeseBox.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@Transactional
@Sql("/test_data.sql")
public class UserRepositoryTests {

	@Autowired
	UserRepository userRepository;
	
	User user2 = new User("Jane", "Doe", "janeDoe1", "example2@email.com", "password", null);
	User user3 = new User("Jamie", "Doe", "jamieDoe1", "example3@email.com", "password", new ArrayList<Recipe>());
	
	@Test
	public void testBefore() {
		assertThat(userRepository.count()).isEqualTo(1);
	}
	
	@Test
	public void testSaveUser() {
		userRepository.save(user2);
		assertThat(userRepository.count()).isEqualTo(2);
		
		userRepository.save(user3);
		assertThat(userRepository.count()).isEqualTo(3);
	}
	
	@Test
	public void testFindById() {
		assertThat(userRepository.findById(1L).getUsername()).isEqualTo("johnDoe1");
	}

	@Test
	public void testFindByUsername() {
		assertThat(userRepository.findByUsername("johnDoe1").getId()).isEqualTo(1L);
		
		userRepository.save(user2);
		userRepository.save(user3);
		assertThat(userRepository.findByUsername("janeDoe1").getFirstName()).isEqualTo("Jane");
		assertThat(userRepository.findByUsername("jamieDoe1").getFirstName()).isEqualTo("Jamie");
	}
	
	@Test
	public void testFindByEmail() {
		assertThat(userRepository.findByEmail("example1@email.com").getUsername()).isEqualTo("johnDoe1");
		
		userRepository.save(user2);
		userRepository.save(user3);
		assertThat(userRepository.findByEmail("example2@email.com").getFirstName()).isEqualTo("Jane");
		assertThat(userRepository.findByEmail("example3@email.com").getFirstName()).isEqualTo("Jamie");
	}
}
