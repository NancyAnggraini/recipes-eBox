package com.propulsion.recipeseBox.service;

import java.util.List;

import com.propulsion.recipeseBox.domain.Ingredient;

public interface IngredientService {

	Ingredient save(Ingredient ingredient);
	
	Ingredient findById(Long id);
	
	Ingredient findByName(String name);
	
	List<Ingredient> findAll();
	
}
