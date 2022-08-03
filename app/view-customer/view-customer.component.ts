import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../model/customer';
import { CustomerserviceService } from '../service/customerservice.service';

@Component({
  selector: 'app-view-customer',
  templateUrl: './view-customer.component.html',
  styleUrls: ['./view-customer.component.css']
})
export class ViewCustomerComponent implements OnInit {
customers:Customer[]=[];
msg:string="";
  constructor(private customerService:CustomerserviceService,private router:Router) { }

  ngOnInit() {
    this.customerService.viewAllCustomers().subscribe(
      response=>{
        this.customers=response;
      }
    )
  }
  public deleteCustomer(customerId:number){
    this.customerService.deleteCustomer(customerId).subscribe(
      response=>{
        console.log(response);
        this.msg=`${customerId}`+"deleted";
        alert("customer deleted");
        window.location.reload();

      }
    )
  }
  public updateCustomer(customer:Customer)
  {
    this.customerService.Updatecustomer(customer).subscribe(
      response=>{
        this.router.navigate(['Updatecustomer',customer]);
      }
    )

    }
  

}

