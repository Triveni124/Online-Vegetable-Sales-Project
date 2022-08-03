import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from '../model/admin';
import { UserserviceService } from '../service/userservice.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
admin:Admin=new Admin();
name:string;
contactNumber:string;
emaiId:string;
email:string;
password:string;
role:string;
  constructor(private userService:UserserviceService,private router:Router) { }

  ngOnInit() {

  }
  public AddUser():void{
    this.userService.addUser(this.admin).subscribe(
      (data)=>{
        console.log(data);
        alert("user Added");
        this.router.navigate(['AddUser']);
      }
    )
  }

}
