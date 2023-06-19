package com.bookstore.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.bookstore.entity.Book;

public class BookDAO extends JpaDAO<Book>implements GenericDao<Book> {

	public BookDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Book create(Book book) {
		book.setLastUpdateTime(new Date());
		return super.create(book);
	}

	@Override
	public Book update(Book book) {
		
		book.setLastUpdateTime(new Date());
		return super.update(book);
	}

	@Override
	public void delete(Object bookId) {
		
		super.delete(Book.class, bookId);
		
	}

	@Override
	public Book get(Object bookId) {
          
		return super.find(Book.class, bookId);
	}

	@Override
	public List<Book> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
	
	
	
	
}
