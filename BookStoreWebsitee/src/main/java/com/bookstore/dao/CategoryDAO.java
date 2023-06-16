package com.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bookstore.entity.Category;
import com.bookstore.entity.Users;

public class CategoryDAO extends JpaDAO<Category> implements GenericDao<Category> {

	public CategoryDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Category create(Category category) {
		// TODO Auto-generated method stub
		return super.create(category);
	}

	@Override
	public Category update(Category category) {
		// TODO Auto-generated method stub
		return super.update(category);
	}
	
	@Override
	public Category get(Object userId) {
	
	return super.find(Category.class, userId);
		
	}

	@Override
	public void delete(Object id) {
		
		super.delete(Category.class, id);
		
	}
	
	
	@Override
	public List<Category> listAll()
	{
		
		return super.findWithNamedQuery("Category.findAll");
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return super.countWithNamedQuery("Category.countAll");
	}

	public Category findByName(String categoryName) {
		List<Category> result =  super.findWithNamedQuery("Category.findByCategory" , "name",categoryName);
		if(result != null && result.size() > 0)
		{
			
			return result.get(0);
			
		}
		
	return null;	
		
	}
	
}
