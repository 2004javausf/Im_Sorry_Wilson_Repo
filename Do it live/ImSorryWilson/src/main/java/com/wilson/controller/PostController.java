package com.wilson.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wilson.entity.Post;
import com.wilson.entity.User;
import com.wilson.service.PostService;

@RestController
@RequestMapping("/home")
@CrossOrigin(origins = "http://localhost:4200")
public class PostController {
	
		PostService postService;
		@Autowired
		PostController(PostService postService){
			this.postService = postService;
		}
		
		@RequestMapping(value = "/feed", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody()
		public List<Post> getAllPosts(){
			return(this.postService.getAllPosts()); //Returns json with null values if does not exist, filled json if it does.
		}
		
		@RequestMapping(value = "/profile", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody()
		public List<Post> getAllPostsByID(@RequestBody User id){
			List<Post> temp = new ArrayList<Post>();
			List<Post> results = new ArrayList<Post>();
			temp = this.postService.getAllPosts();
			for(int i=0; i<temp.size(); i++) {
				if(temp.get(i).getUserID() == id.getId()) { //if username matches
					results.add(temp.get(i));
				}
			}
			return results; //Returns json with null values if does not exist, filled json if it does.
		}
		
		@RequestMapping(value= "/newpost", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody()
		public Post addNewPost(@RequestBody Post post) {
			return this.postService.addPost(post);
		}
}
