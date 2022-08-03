import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VegetableItem } from '../model/vegetableItem';
import { CartService } from '../service/cart.service';

@Component({
  selector: 'app-decrease-veg-quantity',
  templateUrl: './decrease-veg-quantity.component.html',
  styleUrls: ['./decrease-veg-quantity.component.css']
})
export class DecreaseVegQuantityComponent implements OnInit {
vegetable:VegetableItem=new VegetableItem();
flag:boolean;
    quantity: number;
    vegetableId: number;
    msg: any;
    category: string;
    name: string;
    price: number;
  constructor(private cartService:CartService,private router:Router) { }

  ngOnInit() {
  }

  public getVegetableById():void{
    console.log(this.vegetableId);
    this.flag=true;
        this.vegetable
        .getVegetableById(this.vegetableId).subscribe(
          (p)=>{
            
              this.vegetable=p;
              console.log(this.vegetable);
              this.name=this.vegetable.name;
              this.category=this.vegetable.category;
              this.price=this.vegetable.price;
              this.quantity=this.vegetable.quantity;
              //alert(this.msg);
              
            
            
          
          }
        )
        } 
        public DecreaseVegQuantity():void{

          this.vegetable.vegetableId=this.vegetableId;
          this.vegetable.quantity=this.quantity;
          this.cartService.DecreaseVegQuantity(this.quantity,this.vegetableId).subscribe((p)=>this.quantity=p);
          
          //this.vegetableService.increaseVegQuantity(this.vegetable).subscribe((p)=>this.vegetable=p);
          console.log(this.vegetable);
          alert("Vegetable decreased SuccessFully");
        }
}
