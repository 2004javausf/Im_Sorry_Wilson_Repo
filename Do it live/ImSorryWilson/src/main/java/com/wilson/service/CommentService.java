package com.wilson.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilson.dao.CommentDao;
import com.wilson.entity.Comment;
//import com.wilson.entity.Post;

@Service
public class CommentService {
	private CommentDao commentDao;
	@Autowired
	public CommentService(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
	
	public Comment addComment(Comment comment) {
		Date d = new Date(System.currentTimeMillis());
		comment.setCommentDate(d);
		return this.commentDao.save(comment);
	}
	
	public List <Comment> getCommentByPostID(int postID) {
        return this.commentDao.findCommentByPostID(postID);
    } 
	
	public List<Comment> getAllComments(){
		return this.commentDao.findAll();
	}

}
