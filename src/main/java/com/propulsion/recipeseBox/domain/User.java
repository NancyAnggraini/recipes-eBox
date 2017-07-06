package com.propulsion.recipeseBox.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity //creating a table with the class name
@Table(name = "users") //to change table name
@Data
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"password","recipes"})
public class User {

	//fields:
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;
	
	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;
	
	@Column(unique = true, nullable = false, length = 50)
	private String username;
	
	@Column(unique = true, nullable = false, length = 100)
	private String email;
	
	// BCrypt encoded passwords can need 50-76 characters.
	@Column(nullable = false, length = 76)
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Recipe> recipes = new ArrayList<>();
	
	
	public User() {	
		/* default constructor: required by JPA */
	}
	
	//constructor excluding id (no list of recipes):
	public User(String firstName, String lastName, String username, String email, String password) {
		this(null, firstName, lastName, username, email, password);
	}
	
	public User(Long id, String firstName, String lastName, String username, String email, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	//methods:
	public void addRecipe(Recipe recipe) {
		getRecipes().add(recipe);
		recipe.setUser(this);
//		this.recipes.add(recipe);
//		recipe.setUser(this);
	}

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public void setRecipes(List<Recipe> recipes) {
//		this.recipes = recipes;
//	}
//	
	
}


//public User(String firstName, String lastName) {
//this(null, firstName, lastName);
//}

//public User(Long id, String firstName, String lastName) {
//this.id = id;
//this.firstName = firstName;
//this.lastName = lastName;
//}
