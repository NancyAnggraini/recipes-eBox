package com.propulsion.recipeseBox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.propulsion.recipeseBox.domain.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
	
	// Find by recipe.id
	Recipe findById(Long id);
	
	// Find by recipe.name like...
	List<Recipe> findByNameContainingIgnoreCase(String keyword);
	
	// Find by recipe.user.id
	List<Recipe> findByUserId(Long userId); 
	
	// Find by recipe.ingredients like...
//	List<Recipe> findByIngredientInContainingIgnoreCase(List<String> ingredient);
	
	
}

// UPDATING WILL BE DONE LATER:
//@Modifying
//@Query("update Recipe u set u.name = ?1, u.photo_url = ?2, u.weblink = ?3 where u.id = ?4")
//void updateRecipeById(String name, String photoUrl, Long id);
//What about updating List<Ingredient> ingredients, List<String> methods?? 
//Do I need to change them in their respecting magic tables?
