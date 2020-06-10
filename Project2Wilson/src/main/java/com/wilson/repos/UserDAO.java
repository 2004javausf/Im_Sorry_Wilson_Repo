package com.wilson.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wilson.beans.User;

@Repository
public interface UserDAO extends JpaRepository<User,Integer>{
	public User findUserByUsernameAndPassword(String username, String password);
}
