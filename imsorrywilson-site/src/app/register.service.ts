import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Users } from './Users';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http: HttpClient) { }

  registerUser(user:Users): Observable<any>{
    console.log(user);
    return this.http.post<any>('http://localhost:8080/user/register',user); 
  }

}
