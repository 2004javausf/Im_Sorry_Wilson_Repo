package com.wilson.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilson.dao.UserDao;
import com.wilson.entity.User;

@Service
public class UserService {
	@Autowired
	UserDao userDao;
	
	public List<User> getAllUsers() {
		return this.userDao.findAll();
	}
	
	public User addUser(User user) {
		return this.userDao.save(user);
	}
	
	public User getUserByUsername(String username) {
		return this.userDao.findUserByUsername(username);
	}

}
