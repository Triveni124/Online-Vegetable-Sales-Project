import { Component, OnInit } from '@angular/core';
import { Order } from '../model/order';
import { OrderService } from '../service/order.service';

@Component({
  selector: 'app-view-order-by-id',
  templateUrl: './view-order-by-id.component.html',
  styleUrls: ['./view-order-by-id.component.css']
})
export class ViewOrderByIdComponent implements OnInit {
order:Order=new Order();
msg:any;
  orders: Order[];
  flag:boolean=false;
orderId: number;
  constructor(private orderService:OrderService) { }

  ngOnInit() {
  }
  public viewOrderById(){
    this.flag=true;
    this.orderService.viewOrderById(this.orderId).subscribe((p)=>{
    if(p["message"]!= undefined){
        this.msg= p["message"];
        alert(this.msg);
        this.flag=false;}
      else {
        this.orders=p;
      }
    });
  }

}
