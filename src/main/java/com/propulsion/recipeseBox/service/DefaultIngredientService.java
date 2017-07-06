//package com.propulsion.recipeseBox.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.propulsion.recipeseBox.domain.Ingredient;
//import com.propulsion.recipeseBox.repository.IngredientRepository;
//
//@Service
//@Transactional
//public class DefaultIngredientService implements IngredientService {
//
//	private final IngredientRepository ingredientRepository;
//	
//	@Autowired
//	public DefaultIngredientService(IngredientRepository ingredientRepository) {
//		this.ingredientRepository = ingredientRepository;
//	}
//
//	@Override
//	public Ingredient save(Ingredient ingredient) {
//		return this.ingredientRepository.save(ingredient);
//	}
//
//	@Override
//	public Ingredient findById(Long id) {
//		return this.ingredientRepository.findById(id);
//	}
//
//	@Override
//	public Ingredient findByName(String name) {
//		return this.ingredientRepository.findByName(name);
//	}
//
//	@Override
//	public List<Ingredient> findAll() {
//		return this.ingredientRepository.findAll();
//	}
//
//}
