package com.bookstore.entity;
import javax.persistence.*;

@Entity
@NamedQueries({
	
@NamedQuery(name="Users.findAll" , query = "select u from Users u ORDER BY u.fullName"),	
@NamedQuery(name="Users.findByEmail" , query = "select u from Users u WHERE u.email = :email"),	
@NamedQuery(name="Users.countAll" , query = "select Count(*) from Users u")
	
})
@Table(name = "users")
public class Users {
	
	
	
    public Users(Integer userId, String email, String password, String fullName) {
		this(email,fullName,password);
		this.userId = userId;
	}
    
    public Users(String email, String password, String fullName) {
		super();
		this.email = email;
		this.password = password;
		this.fullName = fullName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Users(int userId, String email, String password, String fullName) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.fullName = fullName;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "email", nullable = false, length = 30)
    private String email;

    @Column(name = "password", nullable = false, length = 16)
    private String password;

    @Column(name = "full_name", nullable = false, length = 30)
    private String fullName;

    // Constructors, getters, and setters
}
