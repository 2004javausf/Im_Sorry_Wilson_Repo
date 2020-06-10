package com.wilson.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilson.dao.UserDao;
import com.wilson.entity.User;

@Service
public class UserService {
	@Autowired
	UserDao userDao;
	
	public User addUser(User user) {
		return this.userDao.save(user);
	}

}
