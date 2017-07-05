package com.propulsion.recipeseBox.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity //creating a table with the class name
@Table(name = "users") //to change table name
@AllArgsConstructor
@Data
@EqualsAndHashCode(exclude = "id")
@ToString(exclude = {"password","recipes"})
public class User {

	//fields:
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(unique = true)
	private String username;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	//CascadeType.REMOVE: When deleting an entity, also delete the entities held in this field.
	private List<Recipe> recipes;
	
	
	//empty constructor for JPA:
	public User() {	
	}
	
	//constructor excluding id:
	public User(String firstName, String lastName, String username, String email, String password, List<Recipe> recipes) {
		this(null, firstName, lastName, username, email, password, recipes);
	}
	
	//methods:
	public void addRecipe(Recipe recipe) {
		recipes.add(recipe);
	}
}
