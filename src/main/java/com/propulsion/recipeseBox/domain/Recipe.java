package com.propulsion.recipeseBox.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity //creating a table with the class name
@Table(name = "recipes") //to change table name
@AllArgsConstructor
@Data
@EqualsAndHashCode(exclude = "id")
public class Recipe {

	//fields:
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@ManyToOne
	private User user;
	
	@ManyToMany
	private List<Ingredient> ingredients;
	
	@ElementCollection
	private List<String> methods;
	
	@Column(nullable = true)
	private String photoUrl;
	
	@Column(nullable = true)
	private String weblink;
	
	
	//empty constructor for JPA:
	public Recipe() {
	}
	
	//constructor excluding id:
	public Recipe(String name, User user, List<Ingredient> ingredients, List<String> methods, String photoUrl, String weblink) {
		this(null, name, user, ingredients, methods, photoUrl, weblink);
	}
	
	//methods:
	public void addIngredient(Ingredient ingredient) {
		ingredients.add(ingredient);
	}
	
	public void addCookingMethod(String method) {
		methods.add(method);
	}
}
