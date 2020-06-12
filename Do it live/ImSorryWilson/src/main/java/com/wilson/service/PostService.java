package com.wilson.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilson.dao.PostDao;
import com.wilson.entity.Post;
//import com.wilson.entity.User;

@Service
public class PostService {
	@Autowired
	PostDao postDao;
	
	public List<Post> getAllPosts() {
		return this.postDao.findAll();
	}
	
	public Post addPost(Post post) {
		return this.postDao.save(post);
	}

}
