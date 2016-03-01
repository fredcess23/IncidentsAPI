package com.maranatha.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.maranatha.model.User;

public class UserDAOTest {
	
	private UserDAO userDAO;
	private User user;
	
	@Before
	public void setUpMok() throws SQLException {
		
		userDAO = mock(UserDAOImpl.class);
		user = mock(User.class);
		when(user.getId()).thenReturn(100);
		when(user.getName()).thenReturn("Terry");
		when(user.getLastName()).thenReturn("Cruz");
		when(user.getUsername()).thenReturn("fredyman");
		when(user.getPassword()).thenReturn("daysyman");
		when(user.getAge()).thenReturn(1);
		when(user.getLocationId()).thenReturn(1);
		
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
	}

	@Test
    public void testMockCreation(){
        assertNotNull(userDAO);
        assertNotNull(user);

    }
	
	@Test
    public void testGetUser(){
		when(userDAO.getUser("Terry")).thenReturn(user);
		assertEquals(user,userDAO.getUser("Terry"));
	}
	
}
