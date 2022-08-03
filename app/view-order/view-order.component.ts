import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from '../model/order';
import { OrderService } from '../service/order.service';

@Component({
  selector: 'app-view-order',
  templateUrl: './view-order.component.html',
  styleUrls: ['./view-order.component.css']
})
export class ViewOrderComponent implements OnInit {
  orders:Order[]=[];
  msg:string="";
  orderId: number;
  order: any;
  flag: boolean;
  
  constructor(private orderService:OrderService,private router:Router) { }

  ngOnInit() {
    this.orderService.extractOrder().subscribe(

      response=>
      {
         this.orders=response;
         //console.log(this.order);
      }
    );
  }
  public cancelOrder(orderId:number){
    this.flag=true;
    this.orderService.cancelOrder(orderId).subscribe(
      response=>{
        console.log(response);
        this.msg=`${orderId}`+"canceled";
        alert("order canceled");
       window.location.reload();

      }
    );
  }
}
