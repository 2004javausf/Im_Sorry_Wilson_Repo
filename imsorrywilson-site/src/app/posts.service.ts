import { Injectable } from '@angular/core';
import { Posts } from './Posts';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})


export class PostsService {

  post:Posts={
    id:0,
    userID: 0,
    post:"",
    pic: null,
    likeCount:0,
    postDate:""
  }

  constructor(private httpclient:HttpClient) { }

  httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' })};
  getPostData():Observable<Posts[]>{
    return this.httpclient.get<Posts[]>('http://ec2-3-22-185-47.us-east-2.compute.amazonaws.com:8080/home/feed',this.httpOptions);
  }

  newPost(posts:Posts):Observable<Posts>{
    console.log(posts);
    return this.httpclient.post<any>('http://ec2-3-22-185-47.us-east-2.compute.amazonaws.com:8080/home/newpost',posts);
  }
  likePost(id:number):Observable<number>{
    console.log(id);
    return this.httpclient.post<any>('http://ec2-3-22-185-47.us-east-2.compute.amazonaws.com:8080/home/addlike',id)
  }

  unLikePost(id:number):Observable<number>{
    return this.httpclient.post<any>('http://ec2-3-22-185-47.us-east-2.compute.amazonaws.com:8080/home/sublike',id)
  }
}
