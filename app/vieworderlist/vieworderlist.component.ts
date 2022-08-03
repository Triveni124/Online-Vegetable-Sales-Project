import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from '../model/order';
import { OrderService } from '../service/order.service';

@Component({
  selector: 'app-vieworderlist',
  templateUrl: './vieworderlist.component.html',
  styleUrls: ['./vieworderlist.component.css']
})
export class VieworderlistComponent implements OnInit {
orders:Order[]=[];
msg:string="";
  orderList:any;
  constructor(private orderService:OrderService,private router:Router) { }

  ngOnInit() {
  }
  public viewOrderList()
  {
    this.orderService.orderList().subscribe(
      (      response: Order[])=>{
          this.orders=response;
        }
      );
    }
}
