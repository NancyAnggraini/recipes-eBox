package com.propulsion.recipeseBox.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity //creating a table with the class name
@Table(name = "ingredients") //to change table name
@AllArgsConstructor
@Data
@EqualsAndHashCode(exclude = "id")
public class Ingredient {

	//fields:
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique = true)
	private String name;
	
	@ManyToMany
	@JoinTable(name = "ingredient_recipe", 
			joinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "recipe_id", referencedColumnName = "id"))
	private List<Recipe> recipes;

	
	//empty constructor for JPA:
	public Ingredient(){
	}
	
	//constructor excluding id:
	public Ingredient(String name, List<Recipe> recipes) {
		this(null, name, recipes);
	}
}
