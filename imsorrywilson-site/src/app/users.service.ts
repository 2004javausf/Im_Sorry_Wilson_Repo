import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Users } from './Users';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})


export class UsersService {
  user:Users = {
    id: 0,
    username: "",
    password: "",
    firstName: "Wilson",
    lastName: "I'm Sorry",
    email: "",
    pic: null
  }

  constructor(private httpclient: HttpClient) { }

  setIndividualUser(user):Observable<Users>{
    return this.user = user;
  }
  getIndividualUser(){
    return this.user;
  }
}