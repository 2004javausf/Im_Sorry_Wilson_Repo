package com.wilson.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilson.dao.PostDao;
import com.wilson.entity.Comment;
import com.wilson.entity.Post;

@Service
public class PostService {
	private PostDao postDao;
	@Autowired
	public PostService(PostDao postDao) {
		this.postDao = postDao;
	}
	
	public List<Post> getAllPosts() {
		return this.postDao.findAll();
	}
	
	public Post addPost(Post post) {
		Date d = new Date(System.currentTimeMillis());
		post.setPostDate(d);
		return this.postDao.save(post);
	}
	
	public List <Post> getPostByUserID(int userID) {
        return this.postDao.findPostByUserID(userID);
    } 
	
	public int addLikeCount(int postID) {
		return this.postDao.addLikeCount(postID);
	}
	
	public int subtractLikeCount(int postID) {
		return this.postDao.subtractLikeCount(postID);
	}

}
