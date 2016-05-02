package com.maranatha.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maranatha.dao.UserDAO;
import com.maranatha.model.User;
import com.maranatha.service.UserService;

@Repository
public class UserServiceImpl extends UserService {

	//@Qualifier("userQualifier")
	private UserDAO userDao;
	
	@Autowired
	public void setUserDAO(UserDAO userDao){
		this.userDao = userDao;
	}
	
	public List<User> getAllUsers() {
		return userDao.list();
	}

	public User getPersonByUserName(User user) {
		return userDao.getUser(user.getUsername());
	}

	public boolean addUser(User user) {
		boolean flag = false;
		User currentUser = userDao.getUser(user.getUsername());
		if(currentUser==null){
			flag = userDao.addUser(user);
		}
		return flag;
	}


}
