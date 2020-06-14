package com.wilson.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wilson.entity.Comment;
//import com.wilson.entity.Post;

public interface CommentDao extends JpaRepository <Comment, Integer> {
	
	@Query("FROM Comment WHERE postID = :postID")
    List <Comment> findCommentByPostID(@Param("postID")int postID);

}
