package com.maranatha.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;



//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InOrder;

import com.maranatha.model.User;
import com.maranatha.service.impl.UserServiceImpl;


public class UserDAOTest {
	
	private UserDAO userDAO;
	private User user1;
	private User user2;
	UserServiceImpl userServiceImpl;
	
	private ArrayList<User> userList;

	
	@Before
	public void setUpMok() throws SQLException {
		userDAO = mock(UserDAOImpl.class);
		user1 = mock(User.class);
		user2 = mock(User.class);
		userServiceImpl = new UserServiceImpl();
		userServiceImpl.setUserDAO(userDAO);
		
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
    public void testNotAddUser(){
		
		System.out.println("Stubbing userDAO.getUser(person) to return " + user1);
		when(userDAO.getUser("fredyman")).thenReturn(user1);

		System.out.println("Calling addUser(person) ...");
		boolean flag = userServiceImpl.addUser(user1);
		
		System.out.println("Verifying userDAO.getUser(product) is called");
		verify(userDAO).getUser("fredyman"); //sometimes is redundant!
		
		assertFalse(flag);
	}
	
	@Test
    public void testAddUser(){
		
		System.out.println("Stubbing userDAO.getUser(person) to return " + user1);
		when(userDAO.getUser("fredyman")).thenReturn(null);
		
		System.out.println("Stubbing addUser(person) to return true");
		when(userDAO.addUser(user1)).thenReturn(true);

		System.out.println("Calling addUser(person) ...");
		boolean flag = userServiceImpl.addUser(user1);
		
        System.out.println("Verifying order of method calls on ProductDao: First call getUser() followed by addUser()");
        InOrder order = inOrder(userDAO);
        order.verify(userDAO).getUser("fredyman");
        order.verify(userDAO).addUser(user1);
		
		assertTrue(flag);
	}	
	
	
	
	
	/*
	@Test(expected=HibernateException.class)
    public void testGetUserFailed(){
		when(userDAO.getUser("ttt")).thenThrow(HibernateException.class); //stubbing
	}
	*/
	@Test
    public void testListUser(){
		when(userDAO.list()).thenReturn(userList);
		assertEquals(userList,userDAO.list());

	}
	
}

