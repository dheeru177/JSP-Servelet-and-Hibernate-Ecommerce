package com.bookstore.entity;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "book")
@NamedQueries({

		@NamedQuery(name = "Book.findAll", query = "select b from Book b"),
		@NamedQuery(name = "Book.findByTitle", query = "select t from Book t where t.title =:title"),
		@NamedQuery(name = "Book.countAll", query = "select count(*) from Book b"),
		@NamedQuery(name = "Book.findByCategory", query = "select b from Book b join b.category c where c.categoryId = :catId"),
		@NamedQuery(name = "Book.listNew", query = "SELECT b FROM Book b ORDER BY b.publishDate DESC"),
		@NamedQuery(name = "Book.search" , query="SELECT b FROM Book b WHERE b.title LIKE '%' || :keyword || '%'"
		+ "or b.author like '%' || :keyword || '%'"
		+ " or b.description like '%' || :keyword || '%'")




})
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private int bookId;


	@Column(name = "title", nullable = false, length = 128)
	private String title;

	@Column(name = "author", nullable = false, length = 64)
	private String author;

	@Column(name = "description", nullable = false, columnDefinition = "MEDIUMTEXT")
	private String description;

	@Column(name = "isbn", nullable = false, length = 15)
	private String isbn;

	@Lob
	@Column(name = "image", nullable = false)
	private byte[] image;

	@Transient
	private String base64Image;
	
	@Column(name = "price", nullable = false)
	private float price;

	@Column(name = "publish_date", nullable = false)
	private java.util.Date publishDate;

	@Column(name = "last_update_time", nullable = false)
	private java.util.Date lastUpdateTime;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	/*
	 * private Set<Review> reviews = new HashSet<Review>(0); private
	 * Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);
	 * 
	 * @OneToMany(fetch = FetchType.LAZY , mappedBy = "Book") public Set<Review>
	 * getReviews() { return reviews; }
	 * 
	 * public void setReviews(Set<Review> reviews) { this.reviews = reviews; }
	 * 
	 * @OneToMany(fetch = FetchType.LAZY , mappedBy = "Book") public
	 * Set<OrderDetail> getOrderDetails() { return orderDetails; }
	 * 
	 * public void setOrderDetails(Set<OrderDetail> orderDetails) {
	 * this.orderDetails = orderDetails; }
	 */


	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public int hashCode() {
		return Objects.hash(bookId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return bookId == other.bookId;
	}
	// Constructors, getters, and setters

	public Book(int bookId, String title, String author, String description, String isbn, byte[] image, float price,
			Date publishDate, Timestamp lastUpdateTime, Category category) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.description = description;
		this.isbn = isbn;
		this.image = image;
		this.price = price;
		this.publishDate = publishDate;
		this.lastUpdateTime = lastUpdateTime;
		this.category = category;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public java.util.Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(java.util.Date publishDate2) {
		this.publishDate = publishDate2;
	}

	public java.util.Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(java.util.Date date) {
		this.lastUpdateTime = date;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Transient
	public String getBase64Image() {

		this.base64Image = Base64.getEncoder().encodeToString(this.image);
		return this.base64Image;

	}

	@Transient
	public void setBase64Image(String base64Image)
	{
		
		this.base64Image  = base64Image;
		
	}
	
	
}
