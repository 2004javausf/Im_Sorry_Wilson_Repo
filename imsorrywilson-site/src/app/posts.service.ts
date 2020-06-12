import { Injectable } from '@angular/core';
import { Posts } from './Posts';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})


export class PostsService {

  post:Posts={
    ID:0,
    userID: 0,
    post:"",
    pic: null,
    likeCount:0,
    postDate:""
  }

  constructor(private httpclient:HttpClient) { }

  
  getPostData():Observable<Posts[]>{
    return this.httpclient.get<Posts[]>('http://localhost:8080/home/feed');
  }

  newPost(posts:Posts):Observable<Posts>{
    console.log(posts);
    return this.httpclient.post<any>('http://localhost:8080/home/newpost',posts);
  }
}
