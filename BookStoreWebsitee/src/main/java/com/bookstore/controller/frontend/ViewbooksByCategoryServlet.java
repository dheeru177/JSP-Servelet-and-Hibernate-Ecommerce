package com.bookstore.controller.frontend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bookstore.service.BookServices;


@WebServlet("/view_category")
public class ViewbooksByCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ViewbooksByCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookServices bookServices = new BookServices(request, response);
		bookServices.listBooksByCategory();
		
	}

	

}
