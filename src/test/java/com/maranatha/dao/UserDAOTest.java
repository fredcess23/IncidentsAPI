package com.maranatha.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.maranatha.model.User;

public class UserDAOTest {
	
	private UserDAO userDAO;
	private User user1;
	private User user2;
	private ArrayList<User> userList;

	
	@Before
	public void setUpMok() throws SQLException {
		
		userDAO = mock(UserDAOImpl.class);
		user1 = mock(User.class);
		user2 = mock(User.class);
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
	
	public UserDAOTest() {
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
    public void testGetUser(){
		when(userDAO.getUser("Terry")).thenReturn(user1); //stubbing
		assertEquals(user1,userDAO.getUser("Terry")); //confirmed that the stubbing performed as expected.

	}
	
	@Test(expected=HibernateException.class)
    public void testGetUserFailed(){
		when(userDAO.getUser("Terry")).thenThrow(HibernateException.class); //stubbing
	}
	
	@Test
    public void testListUser(){
		when(userDAO.list()).thenReturn(userList);
		assertEquals(userList,userDAO.list());

	}
	
	@Test
    public void testSave(){
		

	}
}
