package com.bookstore.service;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Users;

public class UserServices {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private UserDAO userDAO;

	public UserServices(HttpServletRequest request , HttpServletResponse response) {
		this.request = request;
		this.response = response;
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsitee");
		entityManager = entityManagerFactory.createEntityManager();
		userDAO = new UserDAO(entityManager);

	}

	public void listUser()
			throws ServletException, IOException {

		listUser(null);
	}

	public void listUser(String message)
			throws ServletException, IOException {

		List<Users> listUsers = userDAO.listAll();

		request.setAttribute("listUsers", listUsers);
		if (message != null) {
			request.setAttribute("message", "New user created successfully");
		}

		String listPage = "user_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);

		requestDispatcher.forward(request, response);

	}

	public void createUser() {

		String email = request.getParameter("email");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");

		Users newUser = new Users(email, fullName, password);
		userDAO.create(newUser);

	}

}
