import { Component, OnInit } from '@angular/core';
import { Customer } from '../model/customer';
import { CustomerserviceService } from '../service/customerservice.service';

@Component({
  selector: 'app-viwe-customer-by-city',
  templateUrl: './viwe-customer-by-city.component.html',
  styleUrls: ['./viwe-customer-by-city.component.css']
})
export class ViweCustomerByCityComponent implements OnInit {
customer:Customer=new Customer();
msg: any;
  customers: Customer[];
  flag: boolean=false;
  constructor(private customerService:CustomerserviceService) { }

  ngOnInit() {
  }
  public viewCustomerByCity():void{
    this.flag=true;
    this.customerService.viewCustomerByCity(this.customer.address.city).subscribe((p)=>{
      if(p["message"]!= undefined){
        this.msg= p["message"];
        alert(this.msg);
        this.flag=false;}
      else {
        this.customers=p;
      }
    });
  }

}
