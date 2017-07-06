package com.propulsion.recipeseBox.repository;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

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
	
	User user2 = new User("Jane", "Doe", "janeDoe1", "example2@email.com", "password");
	User user3 = new User("Jamie", "Doe", "jamieDoe1", "example3@email.com", "password");
	
	@Test
	public void before() {
		assertThat(userRepository.count()).isEqualTo(1);
	}
	
	@Test
	public void saveUser() {
		userRepository.save(user2);
		assertThat(userRepository.count()).isEqualTo(2);
		
		userRepository.save(user3);
		assertThat(userRepository.count()).isEqualTo(3);
	}
	
	@Test
	public void findById() {
		assertThat(userRepository.findById(1L).getUsername()).isEqualTo("johnDoe1");
		assertThat(userRepository.findById(999L)).isNull(); //to avoid null, use optional
		
		List<Recipe> recipes = userRepository.findById(1L).getRecipes();
		assertThat(recipes).isNotNull();
	}

	@Test
	public void findByUsername() {
		assertThat(userRepository.findByUsername("johnDoe1").getId()).isEqualTo(1L);
		
		userRepository.save(user2);
		userRepository.save(user3);
		assertThat(userRepository.findByUsername("janeDoe1").getFirstName()).isEqualTo("Jane");
		assertThat(userRepository.findByUsername("jamieDoe1").getFirstName()).isEqualTo("Jamie");
	}
	
	@Test
	public void findByEmail() {
		assertThat(userRepository.findByEmail("example1@email.com").getUsername()).isEqualTo("johnDoe1");
		
		userRepository.save(user2);
		userRepository.save(user3);
		assertThat(userRepository.findByEmail("example2@email.com").getFirstName()).isEqualTo("Jane");
		assertThat(userRepository.findByEmail("example3@email.com").getFirstName()).isEqualTo("Jamie");
	}
	
	@Test
	public void findAll() {
		userRepository.save(user2);
		userRepository.save(user3);
		
		List<String> firstNames = userRepository.findAll().stream().map(User::getFirstName).collect(toList());
		assertThat(firstNames).containsExactlyInAnyOrder("John", "Jane", "Jamie");
	}
	
	@Test
	public void deleteById() {
		assertThat(userRepository.count()).isEqualTo(1);
		userRepository.delete(1L);
//		userRepository.flush();
		assertThat(userRepository.count()).isEqualTo(0);
	}
	
}
