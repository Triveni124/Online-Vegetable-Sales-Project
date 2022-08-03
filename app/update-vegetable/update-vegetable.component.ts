import { Component, OnInit } from '@angular/core';
import { VegetableItem } from '../model/vegetableItem';
import { VegetableserviceService } from '../service/vegetableservice.service';

@Component({
  selector: 'app-update-vegetable',
  templateUrl: './update-vegetable.component.html',
  styleUrls: ['./update-vegetable.component.css']
})
export class UpdateVegetableComponent implements OnInit {
vegetable:VegetableItem=new VegetableItem();
vegetableId: number;
  flag: boolean= false;
  msg:string;
  name:string;
  category:string;
  price:number;
  quantity:number;
  
  constructor(private vegetableService:VegetableserviceService) { }

  ngOnInit() {
  }

  public getVegetableById():void{
    console.log(this.vegetableId);
    this.flag=true;
        this.vegetableService.getVegetableById(this.vegetableId).subscribe(
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
  
  public updateVegetable():void{
    this.vegetable.name=this.name;
    this.vegetable.category=this.category;
    this.vegetable.price=this.price;
    this.vegetable.quantity=this.quantity;
    this.vegetableService.updateVegetable(this.vegetable).subscribe((p)=>this.vegetable=p);
    console.log(this.vegetable);
    alert("Vegetable Updated SuccessFully");
  }
}
