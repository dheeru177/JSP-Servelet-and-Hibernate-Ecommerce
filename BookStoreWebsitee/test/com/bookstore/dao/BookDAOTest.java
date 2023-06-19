package com.bookstore.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
import java.util.List;

import javax.persistence.EntityNotFoundException;

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
		
		Category category = new Category("Health Cosmetics");
		category.setCategoryId(5);
		newBook.setCategory(category);
		
		
		newBook.setTitle("Effective Java (3nd Edition)");
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
	
	@Test
	public void testCreateBook2() throws ParseException, IOException {
		
		Book newBook = new Book();
		
		Category category = new Category("Java Core");
		category.setCategoryId(1);
		newBook.setCategory(category);
		
		
		newBook.setTitle("Effective Java (4nd Edition)");
		newBook.setAuthor("Dheeraj Dubey");
		newBook.setDescription("Become expert in java from a extraordinary expert");
		newBook.setIsbn("9168049");
		DateFormat dateFormat = new SimpleDateFormat("MM/DD/YYYY");
		Date publishDate = dateFormat.parse("06/19/2023");
		newBook.setPublishDate( publishDate);
		
		String imagePath ="C:\\Users\\User\\OneDrive\\Desktop\\books\\Head First Java.JPG";
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		newBook.setImage(imageBytes);
		
		  Book createdBook = bookDAO.create(newBook);
		  assertTrue(createdBook.getBookId() > 0);
	}
	
	
	
	@Test
	public void testUpdateBook() throws ParseException, IOException {
		
		Book existBook = new Book();
		
		existBook.setBookId(1);
		
		Category category = new Category("Java Core");
		category.setCategoryId(1);
		existBook.setCategory(category);
		
		
		existBook.setTitle("Effective Java (3nd Edition)");
		existBook.setAuthor("Joshua Bloch");
		existBook.setDescription("New coverage of generics, enums, annotations, autoboxing");
		existBook.setPrice(40f);
		existBook.setIsbn("031213546");
		DateFormat dateFormat = new SimpleDateFormat("MM/DD/YYYY");
		Date publishDate = dateFormat.parse("05/20/2008");
		existBook.setPublishDate( publishDate);
		
		String imagePath ="C:\\Users\\User\\OneDrive\\Desktop\\books\\Effective Java.JPG";
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		existBook.setImage(imageBytes);
		
		  Book updateBook = bookDAO.update(existBook);
		  assertEquals(updateBook.getTitle(), "Effective Java (3nd Edition)");
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteBookFail() {
		
		
	Integer bookId = 100;
	bookDAO.delete(bookId);
	
	assertTrue(true);
		
		
	}
	
	@Test()
	public void testGetBookFail() {
		
		
		Integer bookId = 99;
		Book book = bookDAO.get(bookId);
		assertNull(book);
		
	}
	
	@Test()
	public void testGetBookSuccess() {
		
		
		Integer bookId = 2;
		Book book = bookDAO.get(bookId);
		assertNotNull(book);
		
	}
	
	@Test
	public void testListAll()
	{
		
		List<Book> listBooks = bookDAO.listAll();
		for(Book aBook : listBooks)
		{
			
			System.out.println(aBook.getTitle() + "-" + aBook.getAuthor());
			
		}
		
		assertFalse(listBooks.isEmpty());
	}
	
	@Test
	public void testFindByTitleNotExist()
	{
		
		String title = "Thinkin in Java";
		
		Book book = bookDAO.findByTitle(title);
		
		assertNull(book);
		
	}
	
	@Test
	public void testFindByTitleExist()
	{
		
		String title = "Effective Java (3nd Edition)";
		
		Book book = bookDAO.findByTitle(title);
		
		System.out.println(book.getAuthor());
		System.out.println(book.getPrice());
		
		
		assertNotNull(book);
		
	}
	
	
	@Test
	public void testCount() {
		
	long totalBooks = bookDAO.count();	
		
		assertEquals(3, totalBooks);
	}
	
	
	
	@Test()
	public void testDeleteBookSuccess() {
		
		
	Integer bookId = 1;
	bookDAO.delete(bookId);
	
	assertTrue(true);
		
		
	}

}
