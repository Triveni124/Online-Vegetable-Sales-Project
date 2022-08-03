import { Injectable } from '@angular/core';
import { User } from '../model/user';
import { UserserviceService } from './userservice.service';

@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {
user:User;

  constructor(private userService:UserserviceService) { }
  public dologin(email:string,password:string):boolean{
    this.userService.extractUser(email,password).subscribe(
      response=>{
        console.log(response);
        this.user=response;
      }
    );
    if(email==this.user.email && password==this.user.password){
      if(this.user.role=='customer'){
        sessionStorage.setItem("custName",this.user.email);
        sessionStorage.setItem("custPassword",this.user.password);
        console.log(this.user.email+" "+this.user.password);
        return true;
      }
      else if(this.user.role=='admin'){
        sessionStorage.setItem("adminName",this.user.email);
        sessionStorage.setItem("adminPassword",this.user.password);
        console.log(this.user.email+" "+this.user.password);
        return true;
      }
    }
    else{
      return false;
    }
  }
  public isAdmin():boolean{
    let adminName=sessionStorage.getItem('adminName');
    let adminPassword=sessionStorage.getItem('adminPassword');
    console.log(adminName+" "+adminPassword);
    return !(adminName==null);
  }
  public isCustomer():boolean{
    let custName=sessionStorage.getItem('custName');
    let custPassword=sessionStorage.getItem('custPassword');
    console.log(custName+" "+custPassword);
    return !(custName==null);
  }
  public invokeLogout():void{
    sessionStorage.removeItem('custName');
    sessionStorage.removeItem('custPassword');
    sessionStorage.removeItem('adminName');
    sessionStorage.removeItem('adminPassword');
    sessionStorage.clear();
  }
}
