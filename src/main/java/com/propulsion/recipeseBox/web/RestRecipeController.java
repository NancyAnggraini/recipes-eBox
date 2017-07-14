package com.propulsion.recipeseBox.web;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMethodCall;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;

import com.fasterxml.jackson.annotation.JsonView;
import com.propulsion.recipeseBox.domain.JsonViews;
import com.propulsion.recipeseBox.domain.Recipe;
import com.propulsion.recipeseBox.domain.User;
import com.propulsion.recipeseBox.service.RecipeService;
import com.propulsion.recipeseBox.service.UserService;

@RestController
@RequestMapping("/recipes")
public class RestRecipeController {

	private final RecipeService recipeService;
	private final UserService userService;
	
	@Autowired
	public RestRecipeController(RecipeService recipeService, UserService userService) {
		this.recipeService = recipeService;
		this.userService = userService;
	}
	
	//TO LIST ALL OF THE RECIPES OF ALL USERS:
	@JsonView(JsonViews.Public.class)
	@GetMapping
	public List<Recipe> retrieveAllRecipes() {
		List<Recipe> recipes = recipeService.findAll();
		return recipes;	
	}
	
	//TO VIEW ONE CHOSEN RECIPE REGARDLESS THE USER:
	//(CAN BE ALSO USED WHEN A SIGNED IN USER WANTS TO VIEW A SPECIFIC RECIPE)
	//WHEN A RECIPE IS VIEWED, WILL THE INGREDIENTS & METHODS DATA BE THERE TOO?
	@JsonView(JsonViews.Public.class)
	@GetMapping("/{id}")
	public Recipe retrieveRecipeById(@PathVariable Long id) {
		return recipeService.findById(id);
	}
	
	//TO SEARCH A LIST OF RECIPES BY KEYWORD:
	@JsonView(JsonViews.Public.class)
	@RequestMapping(value = "/search", params = "query", method=RequestMethod.GET)
	public List<Recipe> retrieveRecipesContaining(@RequestParam("query")  String keyword) {
		return recipeService.findAllContainingKeyword(keyword);
	}
	
	//FOR AN EXISTING USER TO CREATE NEW RECIPE:
	@JsonView(JsonViews.Public.class)
	@PostMapping("/new_recipe")
	public Recipe createRecipe(@RequestBody Map<String, String> json, @RequestHeader Long userId) {
		User currentUser = userService.findById(userId);
		
		List<String> ingredients = Arrays.asList(json.get("ingredients").split("\\s*,\\s*"));
				
		List<String> cookingMethods = Arrays.asList(json.get("cookingSteps").split("\\s*,\\s*"));
		
		Recipe recipe = new Recipe(json.get("name"), 
								currentUser, 
								ingredients,
								cookingMethods,
								json.get("photoUrl"),
								json.get("weblink"));
		
		currentUser.addRecipe(recipe);
		System.out.println("HERE: " + recipe.getId());
		
		return recipe;
	}
	
}



//Expects {"userId": ?userId, 
//"name": ?name }
//@JsonView(JsonViews.Categories.class)
//@PostMapping("/create")
//public Category createCategory(@RequestBody Map<String, String> json, @RequestHeader Long userId){        
//User user = userService.findUserById(userId);
//Category category = new Category(json.get("name"), false, user);
//userService.addUserCategory(category);
//return category;        
//}


//TO CREATE A NEW RECIPE:
//@PostMapping
//public HttpEntity<Void> createNewRecipe(@RequestBody Recipe postedRecipe) {
//	Recipe savedRecipe = recipeService.saveRecipeForUser(postedRecipe, userId);
//	
//	
//	UriComponents uriComponents = fromMethodCall(
//		on(getClass()).retrieveRecipeById(savedRecipe.getId())).build();
//	
//	return ResponseEntity.created(uriComponents.encode().toUri()).build();
//}

//UriComponents uriComponents = fromMethodCall(
//		on(getClass()).retrieveRecipeById(recipe.getId())).build();
//
//ResponseEntity.created(uriComponents.encode().toUri()).build();
