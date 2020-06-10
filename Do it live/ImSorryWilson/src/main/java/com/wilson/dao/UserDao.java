package com.wilson.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wilson.entity.User;

public interface UserDao extends JpaRepository<User,Integer> {

}
