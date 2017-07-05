package com.propulsion.recipeseBox.service;

import java.util.List;

import com.propulsion.recipeseBox.domain.Recipe;

public interface RecipeService {

	Recipe save(Recipe recipe);
	
	Recipe findById(Long id);
	
	List<Recipe> findByName(String name);
	
	List<Recipe> findByNameContainingIgnoreCase(String keyword);
	
	List<Recipe> findByUserId(Long userId); 
	
	List<Recipe> findAll();
	
	void deleteById(Long id);
}
