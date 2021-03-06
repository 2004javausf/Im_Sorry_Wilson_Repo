import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Users } from './Users';
import { Observable } from 'rxjs';
import { DataSend } from './data';

@Injectable({
  providedIn: 'root'
})


export class UsersService {
  user:Users = {
    id: 7,
    username: "a",
    password: "password",
    firstName: "Wilson",
    lastName: "I'm Sorry",
    email: "",
    pic: null
  }

  constructor(private httpclient: HttpClient) { }
  httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' })};

  setIndividualUser(user):Observable<Users>{
    return this.user = user;
  }
  getIndividualUser(){
    return this.user;
  }

  getAllUsers():Observable<Users[]>{
    return this.httpclient.get<Users[]>('http://ec2-3-22-185-47.us-east-2.compute.amazonaws.com:8080/user/getusers');
  }

  searchForUser(username):Observable<Users>{
    console.log(username);
    return this.httpclient.post<any>('http://ec2-3-22-185-47.us-east-2.compute.amazonaws.com:8080/user/findbyusername',username);
  }

  updateInfo(data:DataSend):Observable<DataSend>{
    console.log(data);
    return this.httpclient.post<any>('http://ec2-3-22-185-47.us-east-2.compute.amazonaws.com:8080/user/updateinfo',data,this.httpOptions);
  }

  updatePassword(user:Users):Observable<Users>{
    return this.httpclient.post<any>('http://ec2-3-22-185-47.us-east-2.compute.amazonaws.com:8080/user/updatepassword',user,this.httpOptions);
  }
}
