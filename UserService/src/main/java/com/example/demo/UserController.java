package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	ResponseEntity<User> createUser(@RequestBody User user){
		User user1=userService.createUser(user);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping
	ResponseEntity<List<User>> getAllUser(){
		List<User> user= userService.getAll();
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/{userId}")
	ResponseEntity<User> getByUserId(@PathVariable String userId){
		User user=userService.getById(userId);
		return ResponseEntity.ok(user);
	}
}
