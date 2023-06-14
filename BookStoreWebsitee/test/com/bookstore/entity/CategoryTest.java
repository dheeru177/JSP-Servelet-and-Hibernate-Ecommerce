package com.bookstore.entity;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.Users;


public class CategoryTest {

	public static void main(String[] args) {
	
	Category cat = new Category("Advanced Java");
	
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsitee");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(cat);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		entityManagerFactory.close();
		
		System.out.println("A cat object was persisted");

	}

}
