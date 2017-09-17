package com.fyme.fts.service;


import java.util.ArrayList;
import java.util.List;

import com.fyme.fts.model.User;

public interface UserService {
	
	User findById(long id);
	
	User findByName(String name);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserById(long id);

	List<ArrayList<User>> findAllUsers();
	
	void deleteAllUsers();
	
	boolean isUserExist(User user);

	public List<User> findAllEmployes();
	
}
