package com.wilson.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wilson.entity.User;

public interface UserDao extends JpaRepository<User,Integer> {
	@Query("FROM User WHERE lower(username) = lower(:username)")
    User findUserByUsername(@Param("username")String username);
}
