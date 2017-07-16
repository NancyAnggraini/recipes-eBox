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
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity //creating a table with the class name
@Table(name = "users") //to change table name
@Data
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"recipes"})
@NoArgsConstructor
public class User {

	//fields:
	@JsonView(JsonViews.Public.class)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JsonView(JsonViews.Public.class)
	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;
	
	@JsonView(JsonViews.Public.class)
	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;
	
	@JsonView(JsonViews.Public.class)
	@Column(unique = true, nullable = false, length = 50)
	private String username;
	
	@JsonView(JsonViews.Public.class)
	@Column(unique = true, nullable = false, length = 100)
	private String email;
	
	@JsonView(JsonViews.NewUser.class)
	// BCrypt encoded passwords can need 50-76 characters.
	@Column(nullable = false, length = 76)
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonBackReference
	private List<Recipe> recipes = new ArrayList<>();
	
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
		this.recipes.add(recipe);
	}


}

