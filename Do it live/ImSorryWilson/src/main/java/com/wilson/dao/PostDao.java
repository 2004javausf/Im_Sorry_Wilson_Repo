package com.wilson.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wilson.entity.Post;

public interface PostDao extends JpaRepository<Post,Integer> {

}
