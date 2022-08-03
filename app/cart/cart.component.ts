import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cart } from '../model/cart';
import { CartService } from '../service/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
cart:Cart=new Cart();
flag: boolean;
  quantity: number;
  vegId: number;
  constructor(private cartService:CartService,private router:Router) { }

  ngOnInit() {
  }
  public addToCart():void{
    console.log(this.cart);
    this.cartService.addToCart(this.cart).subscribe(
      (p)=>
      {
        console.log(p);
        alert("cart added successfully");
        //this.router.navigate(['Add To cart'])
      }
      

    )
}


}
