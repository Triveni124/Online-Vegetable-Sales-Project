import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Feedback } from '../model/feedback';
import { FeedbackServiceService } from '../service/feedback-service.service';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {
feed:Feedback=new Feedback();
  constructor(private route:ActivatedRoute,private router:Router,private feedbackService:FeedbackServiceService) { }

  ngOnInit() {
  }
  public feedback():void{
this.feedbackService.addFeedback(this.feed).subscribe(
  (p)=>{
    console.log(this.feed);
    alert("Feedback Addedd");
  }
)
  }

}
