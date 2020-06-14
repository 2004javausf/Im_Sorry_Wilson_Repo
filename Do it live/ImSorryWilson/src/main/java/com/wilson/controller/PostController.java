package com.wilson.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wilson.entity.Post;
import com.wilson.entity.User;
import com.wilson.service.PostService;
import com.wilson.util.LogThis;

@RestController
@RequestMapping("/home")
@CrossOrigin
public class PostController {
	
		private PostService postService;
		@Autowired
		PostController(PostService postService){
			this.postService = postService;
		}
		
		@RequestMapping(value = "/feed", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody()
		public List<Post> getAllPosts(){
			return(this.postService.getAllPosts()); 
		}
		
		@RequestMapping(value = "/profile", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody()
		public List<Post> getAllPostsByID(@RequestParam int userID){
			return postService.getPostByUserID(userID);
		}
		
		@RequestMapping(value= "/newpost", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody()
		public Post addNewPost(@RequestBody Post post) {
			LogThis.LogIt("info", "Post was created by User Number:" +post.getUserID()+"!");
			return this.postService.addPost(post);
		}
		
		@RequestMapping(value= "/addlike", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody()
<<<<<<< HEAD
		public int addLikeCount(@RequestParam int postID) {
			LogThis.LogIt("info", "Post Number:" +postID+ " was liked!");
=======
		public int addLikeCount(@RequestBody int postID) {
>>>>>>> 744cd2b4198f1aaa810347e50f320382166b9e4e
			return this.postService.addLikeCount(postID);
		}
		
		@RequestMapping(value= "/sublike", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody()
		public int subtractLikeCount(@RequestBody int postID) {
			return this.postService.subtractLikeCount(postID);
		}
}
