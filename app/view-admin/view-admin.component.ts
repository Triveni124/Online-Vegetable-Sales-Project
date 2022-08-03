import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from '../model/admin';
import { UserserviceService } from '../service/userservice.service';

@Component({
  selector: 'app-view-admin',
  templateUrl: './view-admin.component.html',
  styleUrls: ['./view-admin.component.css']
})
export class ViewAdminComponent implements OnInit {
msg:string="";
admins:Admin[]=[];
  constructor(private userService:UserserviceService,private router:Router) { }

  ngOnInit() {
    this.userService.extractAdmin().subscribe(response=>{
      this.admins=response;
    })
  }
  public deleteAdmin(adminId:number){
    this.userService.deleteAdmin(adminId).subscribe(
      response=>{
        console.log(response);
        this.msg=`${adminId}`+"deleted";
        alert("Admin deleted");
      }
    )
  }
  public updateAdmin(adminId:number){
    this.router.navigate(['UpdateAdminComponent',adminId]);
  }

}
