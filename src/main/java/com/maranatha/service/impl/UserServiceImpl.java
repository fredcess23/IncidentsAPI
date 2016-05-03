package com.maranatha.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maranatha.dao.CatIncidentDAO;
import com.maranatha.dao.UserDAO;
import com.maranatha.dto.GenericDTO;
import com.maranatha.model.CatIncident;
import com.maranatha.model.User;
import com.maranatha.service.UserService;

@Repository
public class UserServiceImpl extends UserService {

	// @Qualifier("userQualifier")
	private UserDAO userDao;
	private CatIncidentDAO catIncidentDao;

	@Autowired
	public void setUserDAO(UserDAO userDao) {
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
		if (currentUser == null) {
			flag = userDao.addUser(user);
		}
		return flag;
	}

	@Override
	public List<GenericDTO> search(String name) {
		List<GenericDTO> generics = new ArrayList<GenericDTO>();

		List<User> user = userDao.search(name);
		user.forEach(elem -> {
			GenericDTO genericElem = new GenericDTO();
			genericElem.setName(elem.getName());
			genericElem.setValue(elem);
			generics.add(genericElem);
		});

		List<CatIncident> catIncident = catIncidentDao.search(name);
		catIncident.forEach(elem -> {
			GenericDTO genericElem = new GenericDTO();
			genericElem.setName(elem.getName());
			genericElem.setValue(elem);
			generics.add(genericElem);
		});

		return generics;
	}

}
