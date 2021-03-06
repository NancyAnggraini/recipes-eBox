package com.propulsion.recipeseBox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.propulsion.recipeseBox.domain.User;
import com.propulsion.recipeseBox.domain.Recipe;
import com.propulsion.recipeseBox.repository.RecipeRepository;


@Service
@Transactional
public class DefaultRecipeService implements RecipeService {

	private final RecipeRepository recipeRepository;
	private final UserService userService;
	
	@Autowired
	public DefaultRecipeService(RecipeRepository recipeRepository, UserService userService) {
		this.recipeRepository = recipeRepository;
		this.userService = userService;
	}

	@Override
	@Transactional(readOnly = false)
	public Recipe saveRecipeForUser(Recipe recipe, Long userId) {
		// Link recipe to user.
		User user = userService.findById(userId);
		user.addRecipe(recipe);
		
		// Make sure we are saving a new recipe and not accidentally updating an existing recipe.
//		recipe.setId(null);
		
		return this.recipeRepository.save(recipe);
//		return recipe;
	}

	@Override
	public Recipe findById(Long id) {
		return this.recipeRepository.findById(id);
	}

	@Override
	public List<Recipe> findAllContainingKeyword(String keyword) {
		return this.recipeRepository.findByNameContainingIgnoreCase(keyword);
	}

	@Override
	public List<Recipe> findAllByUserId(Long userId) {
		return this.recipeRepository.findByUserId(userId);
	}

	@Override
	public List<Recipe> findAll() {
		return this.recipeRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		this.recipeRepository.delete(id);
	}

}
