package com.maranatha.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maranatha.dao.UserDAO;
import com.maranatha.model.User;
import com.maranatha.service.UserService;

@Repository
public class UserServiceImpl extends UserService {

	@Autowired
	//@Qualifier("userQualifier")
	private UserDAO userDaoImpl;
	
	public List<User> getAllUsers() {
		return userDaoImpl.list();
	}

	@Override
	public User getPersonByUserName(User user) {
		return userDaoImpl.getUser(user);
	}

}
