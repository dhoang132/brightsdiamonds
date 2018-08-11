package com.brightsdiamonds.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.mindrot.jbcrypt.BCrypt;

public class User {
	
	private int id;
	
	@NotBlank (message="* cannot be empty")
	@Size(min = 1, max = 100)
	@Email(message = "* invalid Email")
	private String email;
	
	@NotBlank(message="* cannot be empty")
	private String firstName;
	
	@NotBlank(message="* cannot be empty")
	private String lastName;
	
	@NotBlank(message="* cannot be empty")
	@Size(min=3, max=10, message = "* min 3 characters required, max 10 characters allowed")
	private String password;
	
	public User() {
		
	}
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
		
	public User(String email, String firstName, String lastName, String password) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
