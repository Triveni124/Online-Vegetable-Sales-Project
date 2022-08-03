import { Component, OnInit } from '@angular/core';
import { Order } from '../model/order';
import { OrderService } from '../service/order.service';

@Component({
  selector: 'app-view-order-by-date',
  templateUrl: './view-order-by-date.component.html',
  styleUrls: ['./view-order-by-date.component.css']
})
export class ViewOrderByDateComponent implements OnInit {
order:Order=new Order();
msg:any;
orders: Order[];
flag:boolean=false;
orderDate: number;
  constructor(private orderService:OrderService) { }

  ngOnInit() {
  }
  public viewOrderByDate(){
    this.flag=true;
    this.orderService.viewOrderByDate(this.orderDate).subscribe((p)=>{
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
