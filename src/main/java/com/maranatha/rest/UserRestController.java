package com.maranatha.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maranatha.dao.UserDAO;
import com.maranatha.model.User;
 
@RestController
public class UserRestController {

	//autowired is always by type, @qualifier is use for autowired by name 
	//@Qualifier("putTheBeanName")
	
	@Autowired
	//@Qualifier("userQualifier")
	private UserDAO userDaoImpl;
	

	
	
	@RequestMapping("/users")
    public List<User> getAllUsers() {
		return userDaoImpl.list();
    }
	
	@RequestMapping("/user/{person}")
    public User getUser(@PathVariable String person) {
		return userDaoImpl.getUser(person);
    }

}