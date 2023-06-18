package com.bookstore.entity;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book")
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

    @Column(name = "price", nullable = false)
    private float price;

    @Column(name = "publish_date", nullable = false)
    private java.util.Date publishDate;

    @Column(name = "last_update_time", nullable = false)
    private java.util.Date lastUpdateTime;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

//    private Set<Review> reviews = new HashSet<Review>(0);
//    private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);
    
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



	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

    // Constructors, getters, and setters
}
