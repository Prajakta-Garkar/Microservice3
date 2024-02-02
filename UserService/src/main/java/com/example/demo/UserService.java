package com.example.demo;

import java.util.List;

public interface UserService {
	
	User createUser(User user);
	User getById(String userId);
	List<User> getAll();

}
