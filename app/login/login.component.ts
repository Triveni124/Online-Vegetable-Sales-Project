import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { LoginserviceService } from '../service/loginservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
email:string;
password:string;
title:string="";
errorMsg:string="Error in login";
invalidMsg:boolean=false;
invalidUser:boolean=false;
user:User;

  constructor(private router:Router,private loginService:LoginserviceService) { }

  ngOnInit() {
    console.log("Welcome");
  }
public handleLogin():void{
  console.log("Welcome"+" "+this.email);
  if(this.loginService.dologin(this.email,this.password)){
   // console.log("Welcome"+this.email);
    this.invalidUser=false;
    this.router.navigate(['welcome',this.email])
  }
  else{
    this.invalidUser=true;
  }
}
}
