package com.propulsion.recipeseBox.service;

import java.util.List;

import com.propulsion.recipeseBox.domain.Recipe;

public interface RecipeService {

	Recipe saveRecipeForUser(Recipe recipe, Long userId);
	
	Recipe findById(Long id);
	
	List<Recipe> findAllContainingKeyword(String keyword);
	
	List<Recipe> findAllByUserId(Long userId); 
	
	List<Recipe> findAll();
	
	void deleteById(Long id);
}
