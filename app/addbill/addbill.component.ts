import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Address } from '../model/address';
import { BillingDetails } from '../model/billing-details';
import { BillserviceService } from '../service/billservice.service';

@Component({
  selector: 'app-addbill',
  templateUrl: './addbill.component.html',
  styleUrls: ['./addbill.component.css']
})
export class AddbillComponent implements OnInit {
bill:BillingDetails=new BillingDetails();
//billingAddress:Address=new Address();
  constructor(private billservice:BillserviceService,private router:Router) { }

  ngOnInit() {
  }
public Submit():void{
  this.billservice.Addbill(this.bill).subscribe(
    (p)=>{
      console.log(this.bill);
      alert("Bill Generated");
      window.location.reload();
    }
  )
}
}
