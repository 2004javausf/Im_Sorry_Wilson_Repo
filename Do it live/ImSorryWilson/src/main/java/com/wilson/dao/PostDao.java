package com.wilson.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wilson.entity.Post;


public interface PostDao extends JpaRepository<Post,Integer> {
	@Query("FROM Post WHERE userID = :userID")
    List <Post> findPostByUserID(@Param("userID")int userID);
	
	@Transactional
	@Modifying
	@Query("UPDATE Post p SET p.likeCount = p.likeCount + 1 WHERE p.ID = :id")
	int addLikeCount( @Param("id")int postID);
	
	@Transactional
	@Modifying
	@Query("UPDATE Post p SET p.likeCount = p.likeCount - 1 WHERE p.ID = :id")
	int subtractLikeCount( @Param("id")int postID);

}
