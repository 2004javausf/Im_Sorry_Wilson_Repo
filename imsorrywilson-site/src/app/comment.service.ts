import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Comments } from './Comment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommentService {
  httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' })};
  constructor(private httpclient:HttpClient) { }

  getCommentData():Observable<Comments[]>{
    return this.httpclient.get<Comments[]>('http://localhost:8080/comment/getcomments',this.httpOptions);
  }

  addComment(comment:Comments):Observable<Comments>{
    return this.httpclient.post<any>('http://localhost:8080/comment/newcomment',comment);
  }
}
