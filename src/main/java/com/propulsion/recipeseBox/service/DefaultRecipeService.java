package com.propulsion.recipeseBox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.propulsion.recipeseBox.domain.Recipe;
import com.propulsion.recipeseBox.repository.RecipeRepository;

@Service
@Transactional
public class DefaultRecipeService implements RecipeService {

	private final RecipeRepository recipeRepository;
	
	@Autowired
	public DefaultRecipeService(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	@Override
	public Recipe save(Recipe recipe) {
		return this.recipeRepository.save(recipe);
	}

	@Override
	public Recipe findById(Long id) {
		return this.recipeRepository.findById(id);
	}

	@Override
	public List<Recipe> findByName(String name) {
		return this.recipeRepository.findByName(name);
	}

	@Override
	public List<Recipe> findByNameContainingIgnoreCase(String keyword) {
		return this.recipeRepository.findByNameContainingIgnoreCase(keyword);
	}

	@Override
	public List<Recipe> findByUserId(Long userId) {
		return this.recipeRepository.findByUserId(userId);
	}

	@Override
	public List<Recipe> findAll() {
		return this.recipeRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		this.recipeRepository.deleteById(id);
	}

}
