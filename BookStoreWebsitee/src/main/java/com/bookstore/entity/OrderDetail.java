package com.bookstore.entity;
import javax.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
    public int getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public BookOrder getOrder() {
		return order;
	}

	public OrderDetail(int orderDetailId) {
		super();
		this.orderDetailId = orderDetailId;
	}

	public void setOrder(BookOrder order) {
		this.order = order;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public OrderDetail(int orderDetailId, BookOrder order, Book book, int quantity, float subtotal) {
		super();
		this.orderDetailId = orderDetailId;
		this.order = order;
		this.book = book;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private int orderDetailId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private BookOrder order;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "subtotal", nullable = false)
    private float subtotal;

    // Constructors, getters, and setters
}
