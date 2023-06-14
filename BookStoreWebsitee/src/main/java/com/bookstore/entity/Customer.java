package com.bookstore.entity;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "customer")
public class Customer {
    public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

	public Customer(int customerId, String email, String fullName, String address, String city, String country,
			String phone, String zipcode, String password, Timestamp registerDate) {
		super();
		this.customerId = customerId;
		this.email = email;
		this.fullName = fullName;
		this.address = address;
		this.city = city;
		this.country = country;
		this.phone = phone;
		this.zipcode = zipcode;
		this.password = password;
		this.registerDate = registerDate;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "email", nullable = false, length = 64)
    private String email;

    @Column(name = "fullname", nullable = false, length = 30)
    private String fullName;

    @Column(name = "address", nullable = false, length = 128)
    private String address;

    @Column(name = "city", nullable = false, length = 32)
    private String city;

    @Column(name = "country", nullable = false, length = 64)
    private String country;

    @Column(name = "phone", nullable = false, length = 15)
    private String phone;

    @Column(name = "zipcode", nullable = false, length = 24)
    private String zipcode;

    @Column(name = "password", nullable = false, length = 16)
    private String password;

    @Column(name = "register_date", nullable = false)
    private Timestamp registerDate;

    // Constructors, getters, and setters
}
