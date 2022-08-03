import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Feedback } from '../model/feedback';
import { ProjectUrl } from '../project-url';

@Injectable({
  providedIn: 'root'
})
export class FeedbackServiceService {
url:string=ProjectUrl.getUrl();
  constructor(private http:HttpClient) { }

  public addFeedback(feed:Feedback):Observable<any>{
    return this.http.post<any>(this.url+"addFeedback",feed);
  }
}
