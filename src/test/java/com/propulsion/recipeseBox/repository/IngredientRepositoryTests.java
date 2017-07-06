//package com.propulsion.recipeseBox.repository;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.test.context.jdbc.Sql;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.propulsion.recipeseBox.domain.Ingredient;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.NONE)
//@Transactional
//@Sql("/test_data.sql")
//public class IngredientRepositoryTests {
//
//	@Autowired
//	IngredientRepository ingredientRepository;
//	
//	Ingredient ingredient2 = new Ingredient("milk");
//	
//	@Test
//	public void testBefore() {
//		assertThat(ingredientRepository.count()).isEqualTo(1);
//	}
//	
//	@Test
//	public void testSaveIngredient() {
//		ingredientRepository.save(ingredient2);
//		assertThat(ingredientRepository.count()).isEqualTo(2);
//	}
//	
//	@Test
//	public void testFindById() {
//		assertThat(ingredientRepository.findById(3L).getName()).isEqualTo("flour");
//	}
//	
//	@Test
//	public void testFindByName() {
//		assertThat(ingredientRepository.findByName("flour").getId()).isEqualTo(3L);
//	}
//
//}
