import { typeWithParameters } from '@angular/compiler/src/render3/util';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Admin } from '../model/admin';
import { UserserviceService } from '../service/userservice.service';

@Component({
  selector: 'app-update-admin',
  templateUrl: './update-admin.component.html',
  styleUrls: ['./update-admin.component.css']
})
export class UpdateAdminComponent implements OnInit {
adId:number;
adminId:number;
name:string;
emailId:string;
contactNumber:string;
email:string;
password:string;
role:string;
admin:Admin;
  constructor(private route:ActivatedRoute,private userService:UserserviceService,private router:Router) { }

  ngOnInit() {
    this.adminId=this.route.snapshot.params['adId'];
    console.log(this.adminId);
    this.userService.extractAdminById(this.adminId).subscribe(response=>{
      this.admin=response;
      this.name=this.admin.name;
      this.contactNumber=this.admin.contactNumber;
      this.emailId=this.admin.emailId;
      this.email=this.admin.user.email;
      this.password=this.admin.user.password;
      this.role=this.admin.user.role;
    })
  }
  public updateAdmin(){
    //this.admin.name=this.name;
    this.admin.contactNumber=this.contactNumber;
    this.admin.emailId=this.emailId;
    /*this.admin.user.email=this.email;
    this.admin.user.password=this.password;
    this.admin.user.role=this.role;*/
    this.userService.updateAdminById(this.admin,this.admin.adminId).subscribe(
      response=>{
        console.log(response);
        alert("Admin Successfully Updated");
        this.router.navigate(['updateAdmin']);
        
      }
    )
  }

}
