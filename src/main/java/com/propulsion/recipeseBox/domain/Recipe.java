package com.propulsion.recipeseBox.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity //creating a table with the class name
@Table(name = "recipes") //to change table name
@Data
@EqualsAndHashCode(of = { "name", "user", "ingredients", "cookingMethods", "photoUrl", "weblink" })
public class Recipe {

	//fields:
	@JsonView(JsonViews.Public.class)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JsonView(JsonViews.Public.class)
	@Column(nullable = false, length = 140)
	private String name;
	
	@ManyToOne
	private User user;
	
	@JsonView(JsonViews.Public.class)
	@ElementCollection
	private List<String> ingredients = new ArrayList<>();
	
	@JsonView(JsonViews.Public.class)
	@ElementCollection
	private List<String> cookingMethods = new ArrayList<>();
	
	@JsonView(JsonViews.Public.class)
	@Column(nullable = true)
	private String photoUrl;
	
	@JsonView(JsonViews.Public.class)
	@Column(nullable = true)
	private String weblink;
	
	
	public Recipe() {
		/* default constructor: required by JPA */
	}
	
	//constructor excluding id:
	public Recipe(String name, User user, List<String> ingredients, List<String> cookingMethods, String photoUrl, String weblink) {
		this.name = name;
		this.user = user;
		this.ingredients = ingredients;
		this.cookingMethods = cookingMethods;
		this.photoUrl = photoUrl;
		this.weblink = weblink;
	}
	
	//constructor with id:
	public Recipe(Long id, String name, User user, List<String> ingredients, List<String> cookingMethods, String photoUrl, String weblink) {
		this(name, user, ingredients, cookingMethods, photoUrl, weblink);
		this.id = id;
	}
	
	//methods:
	public void addIngredient(String ingredient) {
		getIngredients().add(ingredient);
	}
	
	public void addCookingMethod(String cookingMethod) {
		getCookingMethods().add(cookingMethod);
	}
	
	@JsonView(JsonViews.Public.class)
	@JsonProperty
	public String getRecipeOwner() {
		return (this.user != null ? this.user.getUsername() : null);
	}
}
