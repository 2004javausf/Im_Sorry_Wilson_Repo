import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsersService } from '../users.service';
import { Users } from '../Users';
import { Posts } from '../Posts';


@Component({
  selector: 'app-userpage',
  templateUrl: './userpage.component.html',
  styleUrls: ['./userpage.component.css']
})
export class UserpageComponent implements OnInit {

  constructor(private router: Router, private userservice: UsersService) { }

  user:Users = {
    id: 0,
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

  post:Posts={
    ID:0,
    userID: this.user.id,
    post:"",
    pic: null,
    postDate:""
  }
  
  ngOnInit(): void {
    this.user = this.userservice.getIndividualUser();
  }
  charactersRemaining = '190';
  current = '';
  updateCountdown(){
    console.log(this.current)
    this.charactersRemaining = (189 - this.current.length).toString();
  }

  homie(){
    this.home = 0;
    console.log("what")
  }
  settings(){
    this.home = 1;
    console.log(this.home)
  }
  
  searchUName:"";
  search(f){
    this.home = 2;
    this.userservice.searchForUser(f.value).subscribe(res => this.searchedUser = res);
  }
  profile(){
    this.home = 3;
  }
  logout(){
    this.router.navigate(['login']);
  }
}
