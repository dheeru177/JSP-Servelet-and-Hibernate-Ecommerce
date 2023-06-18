package com.bookstore.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

public class BookDAOTest extends BaseDAOTest {

	
	private static BookDAO bookDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		BaseDAOTest.SetUpBeforeClass();
		bookDAO = new BookDAO(entityManager);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		BaseDAOTest.tearDownAfterClass();
		 
	}

	@Test
	public void testCreateBook() throws ParseException, IOException {
		
		Book newBook = new Book();
		
		Category category = new Category("lion");
		category.setCategoryId(7);
		newBook.setCategory(category);
		
		
		newBook.setTitle("Effective Java (2nd Edition)");
		newBook.setAuthor("Joshua Bloch");
		newBook.setDescription("New coverage of generics, enums, annotations, autoboxing");
		newBook.setIsbn("031213546");
		DateFormat dateFormat = new SimpleDateFormat("MM/DD/YYYY");
		Date publishDate = dateFormat.parse("05/20/2008");
		newBook.setPublishDate( publishDate);
		
		String imagePath ="C:\\Users\\User\\OneDrive\\Desktop\\books\\Effective Java.JPG";
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		newBook.setImage(imageBytes);
		
		  Book createdBook = bookDAO.create(newBook);
		  assertTrue(createdBook.getBookId() > 0);
	}

}
