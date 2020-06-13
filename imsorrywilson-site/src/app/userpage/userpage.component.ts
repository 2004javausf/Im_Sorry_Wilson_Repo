import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsersService } from '../users.service';
import { Users } from '../Users';
import { Posts } from '../Posts';
import { PostsService } from '../posts.service';
import { DataSend } from '../data';


@Component({
  selector: 'app-userpage',
  templateUrl: './userpage.component.html',
  styleUrls: ['./userpage.component.css']
})
export class UserpageComponent implements OnInit {

  constructor(private router: Router, private userservice: UsersService, private postservice:PostsService) { }

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

  post:Posts={
    ID:0,
    userID: this.user.id,
    post:"",
    pic: null,
    likeCount: 0,
    postDate:""
  }
  
  ngOnInit(): void {
    this.user = this.userservice.getIndividualUser();
    this.postservice.getPostData().subscribe(res => this.posts = res);
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

  postPic = null;
  fileChange(event){
    this.postPic = event.target.files[0];
  }
  postIt(){
    console.log(this.current);
    let s = this.postPic.name;
    let j = s.split(".");
    let fname = this.user.username + ".png";
    let imgData = new FormData();
    imgData.append('imagefile',this.postPic,fname);
    console.log(imgData);
    this.post.post = this.current;
    this.post.pic = imgData;
    this.postservice.newPost(this.post).subscribe();
  }

  data:DataSend={
    firstName: this.user.firstName,
    lastName:this.user.lastName,
    email:this.user.email,
    username:this.user.username
  }
    
  
  updateInfo(){
    this.data.firstName = this.user.firstName;
    this.data.lastName = this.user.lastName;
    this.data.email = this.user.email;
    console.log(this.data);
  }
  profile(){
    this.home = 3;
  }
  logout(){
    this.router.navigate(['login']);
  }
}
