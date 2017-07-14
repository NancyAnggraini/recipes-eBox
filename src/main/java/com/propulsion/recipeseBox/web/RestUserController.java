package com.propulsion.recipeseBox.web;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMethodCall;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;

import com.fasterxml.jackson.annotation.JsonView;
import com.propulsion.recipeseBox.domain.JsonViews;
import com.propulsion.recipeseBox.domain.Recipe;
import com.propulsion.recipeseBox.domain.User;
import com.propulsion.recipeseBox.service.RecipeService;
import com.propulsion.recipeseBox.service.UserService;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/users")
public class RestUserController {

	private final UserService userService;
	private final RecipeService recipeService;

	@Autowired
	public RestUserController(UserService userService, RecipeService recipeService) {
		this.userService = userService;
		this.recipeService = recipeService;
	}

	//THE APP DOESN'T NEED THIS AT THE MOMENT:
	@JsonView(JsonViews.Public.class)
	@GetMapping
	public List<User> retrieveAllUser() {
		return userService.findAll();	
	}
	
	//TO FIND THE USER AFTER SIGNING-IN:
	@JsonView(JsonViews.Public.class)
	@GetMapping("/{id}")
	public User retrieveUserById(@PathVariable Long id) {
		User user = userService.findById(id);
		System.out.println(user.getRecipes());
		return userService.findById(id);
	}
	
	//TO GET THE LIST OF RECIPES OF A USER:
	@JsonView(JsonViews.Public.class)
	@GetMapping("/{id}/recipes")
	public List<Recipe> retrieveRecipesByUserId(@PathVariable Long id) {
		return recipeService.findAllByUserId(id);
	}
	
	//FOR USER TO CREATE AN ACCOUNT:
	@JsonView(JsonViews.NewUser.class)
	@PostMapping
	public HttpEntity<Void> registerNewUser(@RequestBody User postedUser) {
		User savedUser = userService.save(postedUser);

		UriComponents uriComponents = fromMethodCall(
			on(getClass()).retrieveUserById(savedUser.getId())).build();

		return ResponseEntity.created(uriComponents.encode().toUri()).build();
	}
	
	//CHECK USER LOGIN IN:
	@JsonView(JsonViews.NewUser.class)
	@PostMapping("/login")
	public User retrieveUser(@RequestBody Map<String, String> json) {
		User checkedUser = userService.findByEmail(json.get("email"));
		System.out.println(json.get(checkedUser.getFirstName()));
		System.out.println(json.get(checkedUser.getPassword()));
		
		if(checkedUser.getPassword() == json.get("password")) {
			return checkedUser;
		}
		
		System.out.println(json.get("email"));
		System.out.println(json.get("password"));
		System.out.println(json.get(checkedUser.getFirstName()));
		System.out.println(json.get(checkedUser.getPassword()));
		System.out.println(json.get(checkedUser.getUsername()));
		return null;
	}
	
}

//CHECK USER WHEN LOGGING IN:
//@RequestMapping(value = "sign_in", method = POST, produces = "application/json")
//@ResponseBody
//public User retrieveUser(@RequestBody User postedUsed) {
//	
//}

//public ResponseEntity<User> retrieveUser(@RequestBody User user) {
//	
//	User userChecked = userService.findByEmail(user.getEmail());
//	
//	if (userChecked != null && userChecked.getPassword().equals(user.getPassword())) {
//		token.setToken( this.token );
//    }
//	
//	return ResponseEntity.accepted().body(user);
//}
