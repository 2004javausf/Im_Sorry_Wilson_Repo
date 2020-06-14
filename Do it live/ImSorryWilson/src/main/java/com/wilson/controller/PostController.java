package com.wilson.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
		
		@GetMapping(value = "/feed")
		@ResponseStatus(HttpStatus.OK)
		//@RequestMapping(value = "/feed", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody()
		public List<Post> getAllPosts(){
			return(this.postService.getAllPosts()); 
		}
		
		@GetMapping(value = "/profile")
		@ResponseStatus(HttpStatus.OK)
		@ResponseBody()
		public List<Post> getAllPostsByID(@RequestParam int userID){
			return postService.getPostByUserID(userID);
		}
		
		@GetMapping(value= "/newpost")
		@ResponseStatus(HttpStatus.OK)
		@ResponseBody()
		public Post addNewPost(@RequestBody Post post) {
			LogThis.LogIt("info", "Post was created by User Number:" +post.getUserID()+"!");
			return this.postService.addPost(post);
		}
		
		@GetMapping(value= "/addlike")
		@ResponseStatus(HttpStatus.OK)
		@ResponseBody()
		public int addLikeCount(@RequestParam int postID) {
			LogThis.LogIt("info", "Post Number:" +postID+ " was liked!");
			return this.postService.addLikeCount(postID);
		}
		
		@RequestMapping(value= "/sublike")
		@ResponseStatus(HttpStatus.OK)
		@ResponseBody()
		public int subtractLikeCount(@RequestBody int postID) {
			return this.postService.subtractLikeCount(postID);
		}
}
