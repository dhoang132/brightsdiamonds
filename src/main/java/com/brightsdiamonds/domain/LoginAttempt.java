package com.brightsdiamonds.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.mindrot.jbcrypt.BCrypt;

public class LoginAttempt {

	@NotBlank (message="* cannot be empty")
	@Size(min = 1, max = 100)
	@Email(message = "* invalid Email")
	private String email;
	
	@NotBlank(message="* cannot be empty")
	@Size(min=3, max=10, message = "* min 3 characters required, max 10 characters allowed")
	private String password;
	
	public LoginAttempt() {
		
	}

	public LoginAttempt(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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

	@Override
	public String toString() {
		return "LoginAttempt [email=" + email + ", password=" + password + "]";
	}
	
	public boolean checkPass(String plainPassword, String hashedPassword) {
		if (BCrypt.checkpw(plainPassword, hashedPassword))
			return true;
		else
			return false;
	}
	
}
