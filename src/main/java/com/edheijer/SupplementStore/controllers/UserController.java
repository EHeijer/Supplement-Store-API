package com.edheijer.SupplementStore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edheijer.SupplementStore.models.User;
import com.edheijer.SupplementStore.services.UserService;


@RestController
@RequestMapping
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(path = "/users")
	public List<User> getAllusers(){
		return userService.getAllUsers();
	}
	
	@GetMapping(path = "/users/{id}")
	public User getUserById(@PathVariable("id") int id) {
		return userService.getUser(Integer.toUnsignedLong(id));
	}
	
	@PostMapping(path = "/users")
	public void addUser(@RequestBody User User) {
		userService.addUser(User);
	}
	
	@PutMapping(path = "/users/{id}")
	public void updateUser(@PathVariable("id") int id, @RequestBody User User) {
		userService.updateUser(Integer.toUnsignedLong(id), User);
	}
	
	@DeleteMapping(path = "/users/{id}")
	public void removeUserById(@PathVariable("id") int id) {
		userService.deleteUser(Integer.toUnsignedLong(id));
	}
}
