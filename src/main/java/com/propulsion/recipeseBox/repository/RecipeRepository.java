package com.propulsion.recipeseBox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.propulsion.recipeseBox.domain.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

	@SuppressWarnings("unchecked")
	Recipe save(Recipe recipe);
	
	Recipe findById(Long id);
	
	List<Recipe> findByName(String name);
	
	List<Recipe> findByNameContainingIgnoreCase(String keyword);
	
	//how does it know it’s users id? => the name '...UserId'
	List<Recipe> findByUserId(Long userId); 
	
	//Loop list of recipe, and find match by name:
//	List<Recipe> findByIngredientId(Long ingredientId);
	//WHAT IF SEARCH BY MULTIPLE INGREDIENTS? => LATER
	
	void deleteById(Long id);
	
	
	// UPDATING WILL BE DONE LATER:
	//@Modifying
	//@Query("update Recipe u set u.name = ?1, u.photo_url = ?2, u.weblink = ?3 where u.id = ?4")
	//void updateRecipeById(String name, String photoUrl, Long id);
	//What about updating List<Ingredient> ingredients, List<String> methods?? 
	//Do I need to change them in their respecting magic tables?
	
}
