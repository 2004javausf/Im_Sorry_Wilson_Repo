package com.wilson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wilson.entity.Post;
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
		
		//@GetMapping(value = "/feed")
		@ResponseStatus(HttpStatus.OK)
		@RequestMapping(value = "/feed", method = RequestMethod.GET)
		@ResponseBody()
		public List<Post> getAllPosts(){
			return(this.postService.getAllPosts()); 
		}
		
		//@GetMapping(value = "/profile")
		@RequestMapping(value = "/profile", method = RequestMethod.GET)
		@ResponseStatus(HttpStatus.OK)
		@ResponseBody()
		public List<Post> getAllPostsByID(@RequestParam int userID){
			return postService.getPostByUserID(userID);
		}
		
		//@PostMapping(value= "/newpost")
		@ResponseStatus(HttpStatus.OK)
		@RequestMapping(value = "/newpost", method = RequestMethod.POST)
		@ResponseBody()
		public Post addNewPost(@RequestBody Post post) {
			LogThis.LogIt("info", "Post was created by User Number:" +post.getUserID()+"!");
			return this.postService.addPost(post);
		}
		
		//@GetMapping(value= "/addlike")
		@ResponseStatus(HttpStatus.OK)
		@RequestMapping(value = "/addlike", method = RequestMethod.POST)
		@ResponseBody()
		public int addLikeCount(@RequestBody int postID) {
			LogThis.LogIt("info", "Post Number:" +postID+ " was liked!");
			return this.postService.addLikeCount(postID);
		}
		
		//@RequestMapping(value= "/sublike")
		@RequestMapping(value = "/sublike", method = RequestMethod.POST)
		@ResponseStatus(HttpStatus.OK)
		@ResponseBody()
		public int subtractLikeCount(@RequestBody int postID) {
			return this.postService.subtractLikeCount(postID);
		}
}
