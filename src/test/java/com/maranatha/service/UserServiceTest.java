package com.maranatha.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
//import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InOrder;

import com.maranatha.dao.UserDAO;
import com.maranatha.dao.UserDAOImpl;
import com.maranatha.model.User;
import com.maranatha.service.UserService;
import com.maranatha.service.impl.UserServiceImpl;


public class UserServiceTest {
	
	private UserDAO userDAO;
	private UserServiceImpl userService;
	
	private User user1;
	private User user2;
	private User input;
	private ArrayList<User> userList;

	
	@Before
	public void setUpMok() throws SQLException {
		
		userDAO = mock(UserDAOImpl.class);
		userService = new UserServiceImpl();
		userService.setUserDAO(userDAO);
		
		user1 = mock(User.class);
		user2 = mock(User.class);
		input = mock(User.class);
		
		userList = mock(ArrayList.class);
		
		when(user1.getId()).thenReturn(100);
		when(user1.getName()).thenReturn("Terry");
		when(user1.getLastName()).thenReturn("Cruz");
		when(user1.getUsername()).thenReturn("fredyman");
		when(user1.getPassword()).thenReturn("daysyman");
		when(user1.getAge()).thenReturn(1);
		when(user1.getLocationId()).thenReturn(1);
		
		when(user2.getId()).thenReturn(200);
		when(user2.getName()).thenReturn("Daysy");
		when(user2.getLastName()).thenReturn("Cruz");
		when(user2.getUsername()).thenReturn("cesarca1999");
		when(user2.getPassword()).thenReturn("daysyman");
		when(user2.getAge()).thenReturn(13);
		when(user2.getLocationId()).thenReturn(1);
		
		when(userList.get(0)).thenReturn(user1);
		when(userList.get(1)).thenReturn(user2);
		
		when(input.getUsername()).thenReturn("freyman");
	}
	
	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	
	@After
	public void tearDown() {
		user1 = null;
		user2 = null;
		userList = null;
	}

	@Test
    public void testMockCreation(){
        assertNotNull(userDAO);
        assertNotNull(user1);
        assertNotNull(user2);
    }
	
	
	@Test
    public void shouldAddUser(){
		
		System.out.println("Stubbing getUser(person) to return null");
		when(userDAO.getUser(user1.getUsername())).thenReturn(null);		

		System.out.println("Stubbing addUser(person) to return false");
		when(userDAO.addUser(user1)).thenReturn(true);
		
		System.out.println("Calling userService.addUser(user1) ...");
		boolean flag = userService.addUser(user1);
		
		System.out.println("Verifying userService.addUser(user1) was called");
		verify(userDAO).addUser(user1); //sometimes is redundant!
		
		assertTrue(flag);
	}
	
	@Test(expected=IOException.class)
	public void testForIOException() throws IOException {
	  // create an configure mock
	  OutputStream mockStream = mock(OutputStream.class);
	  doThrow(new IOException()).when(mockStream).close();
	 
	  // use mock
	  OutputStreamWriter streamWriter= new OutputStreamWriter(mockStream);
	  streamWriter.close();
	} 

	
	@Test
	@Ignore
    public void testNoUser(){
		
		System.out.println("Stubbing userDAO.getUser(person) to return " + user1);
		when(userDAO.getUser("fredyman")).thenReturn(null);
		
		System.out.println("Stubbing addUser(person) to return true");
		when(userDAO.addUser(user1)).thenReturn(true);

		System.out.println("Calling userService.addUser(user1) ...");
		boolean flag = userService.addUser(user1);
		
        System.out.println("Verifying order of method calls on ProductDao: First call getUser() followed by addUser()");
        InOrder order = inOrder(userDAO);
        order.verify(userDAO).getUser("fredyman");
        order.verify(userDAO).addUser(user1);
		
		assertTrue(flag);
	}	
	
	
	@Test
    public void testNotRemoveUser(){
		
	}
	
	
	
	/*
	@Test(expected=HibernateException.class)
    public void testGetUserFailed(){
		when(userDAO.getUser("ttt")).thenThrow(HibernateException.class); //stubbing
	}
	*/
	@Test
    public void testGetUser(){
		
		System.out.println("Stubbing userDAO.getUser(user) to return " + user1);
		when(userDAO.getUser(input.getUsername())).thenReturn(user1);

		System.out.println("Calling getPersonByUserName(user) ...");
		User user = userDAO.getUser(input.getUsername());
		
		assertEquals(user,user1);

	}
	
}

