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
    public List<User>  searchPerson(@PathVariable("person")  String person) {
		return userDaoImpl.search(person);
    }

	@RequestMapping(value="/users/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody  User person) {
		userDaoImpl.addUser(person);
    }


	@RequestMapping(value="/users/remove/{personId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeUser(@PathVariable("personId")  Integer personId) {
		userDaoImpl.removeUser(personId);
    }
	
	
	@RequestMapping(value="/users/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean login(@RequestBody  User person) {
		return userDaoImpl.login(person);
    }
	
}