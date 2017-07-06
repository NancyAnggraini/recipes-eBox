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
public class RecipeRepositoryTests {

	@Autowired
	RecipeRepository recipeRepository;
	
	@Autowired
	UserRepository userRepository;
	
	User user3 = new User("Jamie", "Doe", "jamieDoe1", "example3@email.com", "password");
	Recipe recipe2 = new Recipe("Chocolate Cake", user3, new ArrayList<String>(), new ArrayList<String>(), "myFotoUrl", null);
	
	@Test
	public void before() {
		assertThat(recipeRepository.count()).isEqualTo(1);
	}
	
	@Test
	public void saveRecipe() {
		assertThat(recipeRepository.count()).isEqualTo(1);
		userRepository.save(user3);
		recipeRepository.save(recipe2);
		assertThat(recipeRepository.count()).isEqualTo(2);
	}
	
	@Test
	public void deleteRecipeById() {
		assertThat(recipeRepository.count()).isEqualTo(1);
		recipeRepository.delete(2L);
		assertThat(recipeRepository.count()).isEqualTo(0);
	}
	
	@Test
	public void findById() {
		assertThat(recipeRepository.findById(2L).getName()).isEqualTo("Banana Cake");
	}
	
	@Test
	public void findRecipeByNameContaining() {
		userRepository.save(user3);
		recipeRepository.save(recipe2);
		assertThat(recipeRepository.findByNameContainingIgnoreCase("cake").size()).isEqualTo(2);
	}
	
	@Test
	public void findByUserId() {
		assertThat(recipeRepository.findByUserId(1L).size()).isEqualTo(1);
		assertThat(recipeRepository.findByUserId(1L).get(0).getName()).isEqualTo("Banana Cake");
	}

	//add findAll & findByIngredient?

}
