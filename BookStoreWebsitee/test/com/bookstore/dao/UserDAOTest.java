package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

public class UserDAOTest {
	
		
	private static UserDAO userDao;
	
	@BeforeClass
	public static void SetUpClass() {

	    userDao = new UserDAO();
	}

    
    
	@Test
	public void testCreateUsers() {
		Users user1 = new Users();
		user1.setEmail("johnny@gmail.com");
		user1.setFullName("Johnny Smith");
		user1.setPassword("johnny@123");
	     
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
	
	@Test
	public void testGetUsersFound()
	{
		
		Integer userId = 1;
		Users users = userDao.get(userId);
		if(users != null) {
		System.out.println(users.getEmail());
		}
		assertNotNull(users);
		
	}
	
	@Test
	public void testGetUsersNotFound()
	{
		
		Integer userId = 99;
		
		Users user = userDao.get(userId);
		
	      assertNull(user);
		
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteNonExistUsers() {
		
		Integer userId = 55;
         userDao.delete(userId);		
		
		
	}
	
	@Test
	public void testDeleteUsers()
	{
		
		Integer userId = 5;
		
		userDao.delete(userId);
		
		Users user = userDao.get(userId);
		
		assertNull(user);
	}
	
	
	@Test
	public void testListAll()
	{
		
		List<Users> listUsers = userDao.listAll();
		
		for(Users user : listUsers)
		{
			
			System.out.println(user.getEmail());
			
		}
		
		
		assertTrue(listUsers.size() > 0);
	}
	
	@Test
	public void testCheckLoginSuccess() {
		
		
	String email = "ravi@gmail.com";
	String password = "mySecret";
	boolean loginResult = userDao.checklogin(email, password);
	
		assertTrue(loginResult);
	}
	
	@Test
	public void testCheckLoginFailed() {
		
		
	String email = "ravi90@gmail.com";
	String password = "mySecret";
	boolean loginResult = userDao.checklogin(email, password);
	
		assertFalse(loginResult);
	}
	
	@Test
	public void testCount() {
		
		
	long toatlUsers = userDao.count();	
	assertTrue(toatlUsers > 0);
		
	}

	@Test
	public void testCHeckLoginSuccess()
	{
		
		String email = "";
		String password ="";
		
		
		
	}
	
	@Test
	public void testFindByEmail()
	{
		
		
		String email = "dheeru177@gmail.com";
		Users users = userDao.findByEmail(email);
		assertNotNull(users);
		
		
	}
	
	
	
@AfterClass
public static void 	tearDownClass() throws Exception
{
	
	
	
userDao.close();

	
}
}
