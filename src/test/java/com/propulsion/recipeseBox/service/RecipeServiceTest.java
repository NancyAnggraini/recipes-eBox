package com.propulsion.recipeseBox.service;

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
import com.propulsion.recipeseBox.repository.RecipeRepository;
import com.propulsion.recipeseBox.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@Transactional
@Sql("/test_data.sql")
public class RecipeServiceTest {

	@Autowired
	RecipeService recipeService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	RecipeRepository recipeRepository;
	
	@Autowired
	UserRepository userRepository;
	
	User userTest = new User("Testing", "Test", "TestingTest", "testing@email.com", "password");
	Recipe recipeTest = new Recipe("Chocolate Cake", userTest, new ArrayList<String>(), new ArrayList<String>(), "myFotoUrl", null);
	
	@Test
	public void testSaveRecipe () {
		userRepository.save(userTest);
		assertThat(recipeRepository.count()).isEqualTo(16);
		Recipe recipe = recipeService.saveRecipeForUser(recipeTest);
		assertThat(recipeRepository.count()).isEqualTo(17);
		assertThat(recipe.getUser().getRecipes().size()).isEqualTo(1);
		assertThat(recipe.getId()).isNotNull();
	}
}
