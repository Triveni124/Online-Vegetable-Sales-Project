import { Component, OnInit } from '@angular/core';
import { Order } from '../model/order';
import { OrderService } from '../service/order.service';

@Component({
  selector: 'app-update-order',
  templateUrl: './update-order.component.html',
  styleUrls: ['./update-order.component.css']
})
export class UpdateOrderComponent implements OnInit {
order:Order=new Order();

  flag:boolean=false;
  orderId:number;
  msg:any;
  constructor(private orderService:OrderService) { }

  ngOnInit() {
  }

  public getOrderById():void{
    this.flag=true;
        this.orderService.getOrderById(this.orderId).subscribe(
          (p)=>{
            if(p["message"]!= undefined){
              this.msg= p["message"];
              alert(this.msg);
              this.flag=false;
            }
            else {
              this.order=p;
              // this.msg="Customer Updated";
              // alert(this.msg)}
            }
          }
        )
      }
      public updateOrder():void{
        this.orderService.Updateorder(this.order).subscribe((p)=>this.order=p);
        alert("Order Updated SuccessFully");
      }
    
}
