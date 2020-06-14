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
        this.postPic = base64;
        this.user.pic = this.postPic.split(',')[1];
      })
    }
  }
  image;
  onSubmit(r){
    console.log(r.value);
    this.user.username = r.value.username;
    this.user.password = r.value.password;
    this.user.firstName = r.value.firstName;
    this.user.lastName = r.value.lastName;
    this.user.email = r.value.email;
   
    this.register.registerUser(this.user).subscribe();
    window.alert("Account Registered!");
    this.router.navigate(['login']);
  }
}
