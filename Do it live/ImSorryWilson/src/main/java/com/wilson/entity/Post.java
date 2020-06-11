package com.wilson.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="POSTS")
public class Post {
//-----------------------CLASS FIELDS-----------------------
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int ID;
	@Column(name="USER_ID")
	private int userID;
	@Column(name="POST")
	private String post;
	@Column(name="PIC")
	private byte[] pic;
	@Column(name="LIKE_COUNT")
	private int likeCount;
	@Column(name="POST_DATE")
	private Date postDate;
//----------------------------------------------------------

//-----------------------CONSTRUCTORS-----------------------
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(int userID, String post, int likeCount, Date postDate) {
		super();
		this.userID = userID;
		this.post = post;
		this.likeCount = likeCount;
		this.postDate = postDate;
}
	
	
	public Post(int iD, int userID, String post, byte[] pic, int likeCount, Date postDate) {
		super();
		ID = iD;
		this.userID = userID;
		this.post = post;
		this.pic = pic;
		this.likeCount = likeCount;
		this.postDate = postDate;
	}

//----------------------------------------------------------

//---------------------GETTERS & SETTERS--------------------
	public int getID() {
		return ID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
//----------------------------------------------------------

//------------------------TO-STRING-------------------------
	@Override
	public String toString() {
		return "Post [ID=" + ID + ", userID=" + userID + ", post=" + post + ", likeCount=" + likeCount + ", postDate="
				+ postDate + "]";
	}
//----------------------------------------------------------
}
