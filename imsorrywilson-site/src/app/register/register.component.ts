import { Component, OnInit } from '@angular/core';
import { RegisterService } from '../register.service';
import { Users } from '../Users';
import { Router } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';
import { JsonPipe } from '@angular/common';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private router: Router, private register: RegisterService, private httpClient: HttpClient, private sanitizer: DomSanitizer) { }

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

  fileChange(event){
    this.user.pic = event.target.files[0];
  }

 
  onSubmit(r){
    console.log(r.value);
    this.user.username = r.value.username;
    this.user.password = r.value.password;
    this.user.firstName = r.value.firstName;
    this.user.lastName = r.value.lastName;
    this.user.email = r.value.email;
    //JSON.parse(this.user);
    //JSON.stringify(this.user.pic)
    this.register.registerUser(this.user).subscribe();
    window.alert("Account Registered!");
    this.router.navigate(['login']);
  }

  // Placeholder function for the image upload. Needs testing
  onUpload(r){
    console.log(r.value);
    let username = r.value.username;
    let s = this.user.pic.name;
    let j = s.split(".");
    let fname = this.user.username + ".png";
    let imgData = new FormData();
    imgData.append('imagefile',this.user.pic,fname);
    this.httpClient.post("http://localhost:9000/user/updateprofilepic", imgData)
    .subscribe(x =>{
      console.log(x);
    });
    window.alert("Image Uploaded!");
  }
}
