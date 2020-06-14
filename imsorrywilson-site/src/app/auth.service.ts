import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Login } from './Login';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }
  httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' })};
  getUserDetails(login:Login): Observable<any>{
    return this.http.post<any>('http://ec2-3-22-185-47.us-east-2.compute.amazonaws.com:8080/user/login',JSON.stringify(login),this.httpOptions); //change the url
  }
}
