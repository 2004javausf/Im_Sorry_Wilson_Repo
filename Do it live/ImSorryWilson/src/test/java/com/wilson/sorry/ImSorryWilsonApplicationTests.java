package com.wilson.sorry;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wilson.controller.PostController;
import com.wilson.controller.UserController;
import com.wilson.entity.Post;
import com.wilson.entity.User;
@SpringBootTest
class ImSorryWilsonApplicationTests {
	
	@Test
	void contextLoads() {
	}
	
	@Autowired
	UserController uControl;
	
	@Autowired
	PostController pControl;
	
	@Test
	public void findUsernameReturns() throws Exception {
		User user = new User();
		user.setUsername("backslash");
		
		user = uControl.getUserByUsername(user);
		assertTrue(user.getUsername().equals("backslash"));
	}
	
	@Test
	public void findPosts() throws Exception{
		List<Post> posts = new ArrayList();
		
		posts = pControl.getAllPostsByID(7);
		assertTrue(posts.size() != 0);
		
	}

}
