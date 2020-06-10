import { Component, OnInit } from '@angular/core';
import { RegisterService } from '../register.service';
import { Users } from '../Users';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private router: Router, private register: RegisterService) { }

  user:Users = {
    id: 0,
    username: "",
    password: "",
    firstName: "",
    lastName: "",
    email: "",
    pic: null
  }
  ngOnInit(): void {
  }

  onSubmit(r){
    console.log(r.value);
    this.user.username = r.value.username;
    this.user.password = r.value.password;
    this.user.firstName = r.value.firstName;
    this.user.lastName = r.value.lastName;
    this.user.email = r.value.email;
    // this.user.pic = r.value.pic;
    console.log(this.user);
    this.register.registerUser(this.user).subscribe();
    window.alert("Account Registered!");
    this.router.navigate(['login']);
  }
}
