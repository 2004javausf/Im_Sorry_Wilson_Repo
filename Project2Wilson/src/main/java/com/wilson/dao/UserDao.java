package com.wilson.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wilson.model.User;

@Repository
public interface UserDao extends JpaRepository <User, Long> {

}
