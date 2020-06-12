package com.wilson.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wilson.entity.Post;


public interface PostDao extends JpaRepository<Post,Integer> {
	@Query("FROM Post WHERE userID = :userID")
    List <Post> findPostByUserID(@Param("userID")int userID);
}
