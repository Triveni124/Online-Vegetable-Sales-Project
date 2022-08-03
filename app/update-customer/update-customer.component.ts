import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../model/customer';
import { CustomerserviceService } from '../service/customerservice.service';
import { ViewCustomerComponent } from '../view-customer/view-customer.component';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {
  customer: Customer=new Customer();
  flag: boolean= false;
  customerId: number;
  msg: any;
  constructor(private customerService:CustomerserviceService,private router:Router) { }

  ngOnInit() {
  }
  public getCustById():void{
this.flag=true;
    this.customerService.getCustomerById(this.customerId).subscribe(
      (p)=>{
        if(p["message"]!= undefined){
          this.msg= p["message"];
          alert(this.msg);
          this.flag=false;
        }
        else {
          this.customer=p;
          // this.msg="Customer Updated";
          // alert(this.msg)}
        }
      }
    )
  }
  public updateCustomer():void{
    this.customerService.Updatecustomer(this.customer).subscribe((p)=>this.customer=p);
    console.log(this.customer);
    alert("Customer Updated SuccessFully");
    //this.router.navigate(['updateCustomer',ViewCustomerComponent]);
  }

}
