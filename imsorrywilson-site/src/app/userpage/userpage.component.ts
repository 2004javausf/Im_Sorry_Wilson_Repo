import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsersService } from '../users.service';
import { Users } from '../Users';
import { Posts } from '../Posts';
import { PostsService } from '../posts.service';
import { DataSend } from '../data';
import { ReadVarExpr } from '@angular/compiler';
import { rejects } from 'assert';
import { splitAtColon } from '@angular/compiler/src/util';
import { Comments } from '../Comment';
import { CommentService } from '../comment.service';


@Component({
  selector: 'app-userpage',
  templateUrl: './userpage.component.html',
  styleUrls: ['./userpage.component.css']
})
export class UserpageComponent implements OnInit {

  constructor(private router: Router, private userservice: UsersService, private postservice:PostsService, private commentservice:CommentService) { }

  ngOnInit(): void {
    this.user = this.userservice.getIndividualUser();
    this.postservice.getPostData().subscribe(res => this.posts = res);
    this.commentservice.getCommentData().subscribe(res => this.comments = res);
  }

  user:Users = {
    id: 7,
    username: "",
    password: "",
    firstName: "",
    lastName: "",
    email: "",
    pic: null
  }

  searchedUser:Users = {
    id: 0,
    username: "",
    password: "",
    firstName: "",
    lastName: "",
    email: "",
    pic: null
  }

  home:number = 0; //0 for user page, 1 for settings page, 2 for search //3 for user profile page

  posts:Posts[];
  
  comments:Comments[];
  comment:Comments = {
    id:0,
    postID:0,
    userName:"",
    comment:"",
    commentDate:""
}

  get sortData(){
    return this.posts.sort((a,b) =>{
      return <any>new Date(b.postDate) - <any>new Date(a.postDate);
    });
  }
  post:Posts={
    id:0,
    userID: this.user.id,
    post:"",
    pic: null,
    likeCount: 0,
    postDate:""
  }
  
 

  charactersRemaining = '200';
  current = '';
  updateCountdown(){
    this.charactersRemaining = (199 - this.current.length).toString();
  }

  homie(){
    this.home = 0;
  }
  settings(){
    this.home = 1;
  }
  
  searchUName:"";
  search(f){
    this.home = 2;
    this.userservice.searchForUser(f.value).subscribe(res => this.searchedUser = res);
  }
  profile(){
    this.home = 3;
  }

  changeFile(file) {
    return new Promise((resolve, reject) => {
      const reader = new FileReader();
      reader.readAsDataURL(file);
      reader.onload = () => resolve(reader.result);
      reader.onerror = (error) => reject(error);
    });
  }
  imagePreview:any;
  postPic:any;
  fileChange(event){
    this.postPic = event.target.files[0];
    if(event.target.value){
      const file = event.target.files[0];
      this.changeFile(file).then((base64:string):any=>{
       this.imagePreview = [base64];
        this.postPic = base64;
        this.post.pic = this.postPic.split(',')[1];
      })
    }
  }
  image;
  postIt(){
    this.post.userID = this.user.id;
    this.post.post = this.current;
    this.postservice.newPost(this.post).subscribe();
    window.alert("Your post has been made!");
    this.post.id=0;
    this.post.userID= this.user.id;
    this.post.post="";
    this.post.pic= null;
    this.post.likeCount= 0;
    this.post.postDate="";
    this.current = "";
    this.postPic = null;
  }

  data:DataSend={
    firstName: this.user.firstName,
    lastName:this.user.lastName,
    email:this.user.email,
    pic: this.user.pic,
    username:this.user.username
  }
    
  fileChange1(event){
    this.postPic = event.target.files[0];
    if(event.target.value){
      const file = event.target.files[0];
      this.changeFile(file).then((base64:string):any=>{
       this.imagePreview = [base64];
        this.postPic = base64;
        this.user.pic = this.postPic.split(',')[1];
      })
    }
  }
  updateInfo(){
    this.data.firstName = this.user.firstName;
    this.data.lastName = this.user.lastName;
    this.data.email = this.user.email;
    this.data.pic = this.user.pic;
    this.data.username = this.user.username;
    this.userservice.updateInfo(this.data).subscribe();
    window.alert("Your changes have been saved");
    this.home = 0;
  }

  vPassword = "";
  isHidden = true;
  verifyPassword(){
    if (this.vPassword == this.user.password){
      this.isHidden = false;
    }else{
      window.alert('Password does not match');
    }
  }

  newPassword = "";
  updatePassword(){
    console.log(this.newPassword);
    this.user.password = this.newPassword;
    console.log(this.user.password);
    this.userservice.updatePassword(this.user).subscribe();
    window.alert("Your password has been updated");
    this.vPassword = "";
    this.isHidden = true;
    this.home = 0;
  }
  radioStatus:boolean = true;
  like(event,id,like){
    this.radioStatus = !event;
    console.log(event);
    console.log(id);
    console.log(like);
    if(event == true){
     this.postservice.likePost(id).subscribe();
    }else if(event == false){
      this.postservice.unLikePost(id).subscribe();
    }
  }

  updateCommentText(){
    console.log("now what")
  }
  commentOn(postID,username){
    this.comment.postID = postID;
    this.comment.userName = username;
    console.log(this.comment);
    this.commentservice.addComment(this.comment).subscribe();
  }
  logout(){
    this.router.navigate(['login']);
  }
}



