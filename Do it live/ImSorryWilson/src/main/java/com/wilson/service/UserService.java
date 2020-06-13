package com.wilson.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilson.dao.UserDao;
import com.wilson.entity.User;

@Service
public class UserService {
	private UserDao userDao;
	
	@Autowired
	UserService(UserDao userDao){
		this.userDao = userDao;
	}
	
	public User login(String username, String password) {
		return this.userDao.login(username, password);
	}
	
	public List<User> getAllUsers() {
		return this.userDao.findAll();
	}
	
	public User addUser(User user) {
		return this.userDao.save(user);
	}
	
	public User getUserByUsername(String username) {
        return this.userDao.findUserByUsername(username);
    }
	
	public int updatePassword(String newPassword, int userID) {
		return this.userDao.updatePassword(newPassword, userID);
	}
	
	public int updateInformation(String firstName, String lastName, String email, String username) {
		return this.userDao.updateInformation(firstName, lastName, email, username);
	}

}
