import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from '../model/order';
import { OrderService } from '../service/order.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
order:Order=new Order();

  constructor(private orderService:OrderService,private router:Router) { }

  ngOnInit() {
  }
  public addOrder():void{
    console.log(this.order);
    this.orderService.addOrder(this.order).subscribe(
      (p)=>
      {
      
      alert("order added");
      this.router.navigate(['orderList']);
      }
      
      
    
    );
  }



}
