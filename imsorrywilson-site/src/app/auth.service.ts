import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Login } from './Login';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  getUserDetails(login:Login): Observable<any>{
    console.log(JSON.stringify(login));

    return this.http.post<any>('http://localhost:8080/user/login',login); //change the url
  }
}
