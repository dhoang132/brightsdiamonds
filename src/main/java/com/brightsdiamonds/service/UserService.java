package com.brightsdiamonds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brightsdiamonds.dao.UserDao;
import com.brightsdiamonds.domain.User;



@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public List<User> getUserList(){
		List<User> userList = userDao.getAllUsers();
		return userList;
	}
	
	public User getUser(String email) {
		User user = userDao.getUser(email);
		return user;
	}
	
	public void createUser(User user) {
		userDao.create(user);
	}
	
	public String getUserPassword(String email) {
		return userDao.getUserPassword(email);
	}
}

