package com.maranatha.service;

import java.util.List;

import com.maranatha.model.User;
import com.util.GenericCache;

public abstract class UserService extends GenericCache<User, User>{

	public abstract List<User> getAllUsers();
	public abstract User getPersonByUserName(User user);
	
	public User send1(User user) {
		return getPersonByUserName(user);
	}

	public List<User> send2() {
		return getAllUsers();
	}
	
}
