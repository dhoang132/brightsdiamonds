package com.brightsdiamonds.dao;

import java.util.List;

import javax.sql.DataSource;

import com.brightsdiamonds.domain.User;

public interface UserDao {
	public void setDataSource(DataSource ds);
	
	public boolean create(User user);
	
	public List<User> getAllUsers();
	
	public User getUser(String email);
	
	public String getUserPassword(String email);
	
	public boolean delete(User user);
	
	public boolean update(User user);
	
	public void cleanup();
}
