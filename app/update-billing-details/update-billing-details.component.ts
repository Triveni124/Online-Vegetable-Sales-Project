import { Component, OnInit } from '@angular/core';
import { BillingDetails } from '../model/billing-details';
import { BillserviceService } from '../service/billservice.service';

@Component({
  selector: 'app-update-billing-details',
  templateUrl: './update-billing-details.component.html',
  styleUrls: ['./update-billing-details.component.css']
})
export class UpdateBillingDetailsComponent implements OnInit {
  billingDetails =new BillingDetails();
  billId: number;
  transactionMode:string;
  flag: boolean=false;
  msg: any;
  constructor(private billservice:BillserviceService) { }

  ngOnInit() {
  }
  public getBillingDetailsById():void{
    this.flag=true;
    this.billservice.getBillingDetailsById(this.billId).subscribe(
      (p)=>{
      if(p["message"]!= undefined){
        this.msg= p["message"];
        alert(this.msg);
        this.flag=false;}
        else {
          this.billingDetails=p;
        }

    });
  }

    public updateBill(): void{
      
      this.billservice.updateBill(this.billingDetails).subscribe(
        (p)=>
         this.billingDetails=p);
      alert("Billing updated Successfully");
    }
  

}
