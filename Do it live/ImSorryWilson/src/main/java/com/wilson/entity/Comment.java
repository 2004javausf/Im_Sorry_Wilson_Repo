package com.wilson.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COMMENTS")
public class Comment {
//-----------------------CLASS FIELDS-----------------------
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int ID;
	@Column(name="POST_ID")
	private int postID;
	@Column(name="USER_NAME")
	private String userName;
	@Column(name="USER_COMMENT")
	private String comment;
	@Column(name="COMMENT_DATE")
	private Date commentDate;
//----------------------------------------------------------

//-----------------------CONSTRUCTORS-----------------------
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(int ID, int postID, String userName, String comment, Date commentDate) {
		super();
		this.ID = ID;
		this.postID = postID;
		this.userName = userName;
		this.comment = comment;
		this.commentDate = commentDate;
}	
//----------------------------------------------------------

//---------------------GETTERS & SETTERS--------------------
	public int getID() {
		return ID;
	}

	public int getPostID() {
		return postID;
	}

	public void setPost(int postID) {
		this.postID = postID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
//----------------------------------------------------------

//------------------------TO-STRING-------------------------
	@Override
	public String toString() {
		return "Comment [ID=" + ID + ", post=" + postID + ", user=" + userName + ", comment=" + comment + ", commentDate="
				+ commentDate + "]";
	}	
//----------------------------------------------------------
}
