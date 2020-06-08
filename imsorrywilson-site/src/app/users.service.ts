import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Users } from './Users';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})


export class UsersService {
  user:Users = {
    uID: 0,
    username: "",
    password: ""
  }

  constructor(private httpclient: HttpClient) { }

  setIndividualUser(user):Observable<Users>{
    return this.user = user;
  }
  getIndividualUser(){
    return this.user;
  }
}
