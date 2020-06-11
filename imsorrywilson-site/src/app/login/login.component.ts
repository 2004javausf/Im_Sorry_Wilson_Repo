import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Login } from '../Login';
import { Router } from '@angular/router';
import { UsersService } from '../users.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private auth: AuthService, private router: Router, private userservice: UsersService) { }

  ngOnInit(): void {
  }
  login : Login = {
    username: "",
    password: ""
  }

  onSubmit(f){
    this.login.username = f.value.username;
    this.login.password = f.value.password;
    this.auth.getUserDetails(this.login).subscribe(res=> {
      console.log(res);
      if (res.id == null){
        window.alert('Invalid credentials')
      } else{
        this.router.navigate(['user']);
        this.userservice.setIndividualUser(res);
      }
    });
  }
}