package com.bookstore.entity;
import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    public Category(String name) {
		super();
		this.name = name;
	}

	public Category(int categoryId, String name) {
		super();
		this.categoryId = categoryId;
		this.name = name;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

    // Constructors, getters, and setters
}
