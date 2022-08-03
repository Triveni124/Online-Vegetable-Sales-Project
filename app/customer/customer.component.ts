import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../model/customer';
import { CustomerserviceService } from '../service/customerservice.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
customer:Customer=new Customer();
  constructor(private route:ActivatedRoute,private customerService:CustomerserviceService,private router:Router) { }

  ngOnInit() {
  }
public AddCustomer():void{
  this.customerService.AddCustomer(this.customer).subscribe(
    (cust)=>{
      console.log(this.customer);
      alert("Customer Registed Successfully");
      this.router.navigate(['AddCustomer'])
    }
  )
}
}
