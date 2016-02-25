package com.maranatha.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maranatha.dao.UserDAO;
import com.maranatha.model.User;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
 
@RestController
//@EnableAutoConfiguration

public class UserRestController {

	//autowired is always by type, @qualifier is use for autowired by name 
	//@Qualifier("putTheBeanName")
	
	@Autowired
	//@Qualifier("userQualifier")
	private UserDAO userDaoImpl;
	

	
	@RequestMapping(value="/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {
		return userDaoImpl.list();
    }


	@RequestMapping(value="/users/{person}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User searchPerson(@PathVariable("person")  String person) {
		return userDaoImpl.search(person);
    }

	@RequestMapping(value="/users/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody  User person) {
		userDaoImpl.addUser(person);
    }
}