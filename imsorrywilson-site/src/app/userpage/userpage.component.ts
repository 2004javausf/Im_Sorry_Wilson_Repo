import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsersService } from '../users.service';
import { Users } from '../Users';


@Component({
  selector: 'app-userpage',
  templateUrl: './userpage.component.html',
  styleUrls: ['./userpage.component.css']
})
export class UserpageComponent implements OnInit {

  constructor(private router: Router, private userservice: UsersService) { }

  user:Users = {
    uID: 0,
    username: "",
    password: "",
    firstName: "",
    lastName: "",
    email: "",
    pic: ""
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
}
