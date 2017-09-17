package com.fyme.fts.dao;

import java.util.List;

import com.fyme.fts.model.User;

public interface UserDao {

	public List<User> findAllEmployes();

	public void updateCoordinateForUser(User user);
}
