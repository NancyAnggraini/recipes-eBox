package com.propulsion.recipeseBox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.propulsion.recipeseBox.domain.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

	@SuppressWarnings("unchecked")
	Ingredient save(Ingredient ingredient);
	
	Ingredient findById(Long id);
	
	Ingredient findByName(String name);
	
}

//WHAT ABOUT QUANTITY??? => at the moment, no handling quantity (it'll be text in the methods)
