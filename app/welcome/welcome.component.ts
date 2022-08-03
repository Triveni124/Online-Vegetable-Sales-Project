import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginserviceService } from '../service/loginservice.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
name:string="";
msg:string="";
adminFlag:boolean;
customerFlag:boolean;
  constructor(private route:ActivatedRoute,private router:Router,private loginService:LoginserviceService) { }

  ngOnInit() {
    this.name=this.route.snapshot.params['name']
    this.adminFlag=this.loginService.isAdmin();
    this.customerFlag=this.loginService.isCustomer();
  }

}
