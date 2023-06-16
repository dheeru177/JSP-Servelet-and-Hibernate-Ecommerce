package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Category;

public class CategoryService {

	
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private CategoryDAO categoryDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private UserDAO userDAO;
	
	
	public CategoryService(EntityManager entityManager ,HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	     this.entityManager = entityManager;
		categoryDAO = new CategoryDAO(entityManager);
	}


public void listCategory() throws ServletException, IOException {
	
	
	List<Category> listCategory = categoryDAO.listAll();
	
	request.setAttribute("listCategory", listCategory);
	

	String listPage = "category_list.jsp";
	RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);

	requestDispatcher.forward(request, response);

}
	
}
