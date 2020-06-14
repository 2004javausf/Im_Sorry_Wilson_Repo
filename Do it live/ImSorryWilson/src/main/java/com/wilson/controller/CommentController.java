package com.wilson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wilson.entity.Comment;
import com.wilson.entity.Post;
import com.wilson.service.CommentService;
import com.wilson.util.LogThis;

@RestController
@RequestMapping("/comment")
@CrossOrigin
public class CommentController {
	
	private CommentService commentService;
	@Autowired
	CommentController(CommentService commentService){
		this.commentService = commentService;
	}
	
	//@GetMapping(value= "/newcomment")
	@RequestMapping(value = "/newcomment", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody()
	public Comment addNewComment(@RequestBody Comment comment) {
		LogThis.LogIt("info", "Comment was made by User:" +comment.getUserName()+ " on Post Number:" +comment.getPostID()+"!");
		return this.commentService.addComment(comment);
	}
	
	//@GetMapping(value = "/getcomments")
	@RequestMapping(value = "/getcommentsbyid", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody()
	public List<Comment> getAllCommentsById(@RequestParam int postID){
		return commentService.getCommentByPostID(postID);
	}
	
	@RequestMapping(value = "/getcomments", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody()
	public List<Comment> getAllComments(){
		return commentService.getAllComments();
	}

}
