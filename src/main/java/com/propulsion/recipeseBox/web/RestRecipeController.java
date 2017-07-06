package com.propulsion.recipeseBox.web;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMethodCall;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;

import com.fasterxml.jackson.annotation.JsonView;
import com.propulsion.recipeseBox.domain.JsonViews;
import com.propulsion.recipeseBox.domain.Recipe;
import com.propulsion.recipeseBox.service.RecipeService;

@RestController
@RequestMapping("/recipes")
public class RestRecipeController {

	private final RecipeService recipeService;
	
	@Autowired
	public RestRecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
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
	
	//TO CREATE A NEW RECIPE:
//	@PostMapping
//	public HttpEntity<Void> createNewRecipe(@RequestBody Recipe postedRecipe) {
//		Recipe savedRecipe = recipeService.saveRecipeForUser(postedRecipe, userId);
//		
//		
//		UriComponents uriComponents = fromMethodCall(
//			on(getClass()).retrieveRecipeById(savedRecipe.getId())).build();
//		
//		return ResponseEntity.created(uriComponents.encode().toUri()).build();
//	}

	
	
}
