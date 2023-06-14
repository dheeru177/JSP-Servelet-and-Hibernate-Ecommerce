package com.bookstore.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

public class UserDAOTest {
	
	private static EntityManagerFactory entityManagerFactory ;

	private static EntityManager entityManager;
	
	private static UserDAO userDao;
	
	@BeforeClass
	public static void SetUpClass() {
	    entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsitee");
	    entityManager = entityManagerFactory.createEntityManager();
	    userDao = new UserDAO(entityManager);
	}

    
    
	@Test
	public void testCreateUsers() {
		Users user1 = new Users();
		user1.setEmail("tommy@codejava.net");
		user1.setFullName("tommy timothy");
		user1.setPassword("abcdefghij");
	     
	   user1 =  userDao.create(user1);
		
		
		
	   assertTrue(user1.getUserId() > 0);
		
	}
	
	
	@Test(expected = PersistenceException.class)
	public void testCreateUsersFieldsNotSet()
	{
		
		Users user1 = new Users();

		 
	   user1 =  userDao.create(user1);
		
		
	
		
		
		
	}
	
	@Test
	public void testUpdateUsers()
	{
		
		Users user = new Users();
		user.setUserId(1);
		user.setEmail("ravi@gmail.com");
		user.setFullName("Ravi Dubey");
		user.setPassword("mySecret");
		user = userDao.update(user);
		String expected = "mySecret";
		String acctual = user.getPassword();
		assertEquals(expected, acctual);
	}
	
	
	
@AfterClass
public static void 	tearDownClass()
{
	
	
	
	entityManagerFactory.close();
	entityManager.close();

	
}
}
