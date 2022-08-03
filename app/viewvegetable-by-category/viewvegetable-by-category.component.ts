import { Component, OnInit } from '@angular/core';
import { VegetableItem } from '../model/vegetableItem';
import { VegetableserviceService } from '../service/vegetableservice.service';

@Component({
  selector: 'app-viewvegetable-by-category',
  templateUrl: './viewvegetable-by-category.component.html',
  styleUrls: ['./viewvegetable-by-category.component.css']
})
export class ViewvegetableByCategoryComponent implements OnInit {
vegetable:VegetableItem=new VegetableItem();
vegetables:VegetableItem[];
category: any;
  name:any;
  msg: any;
  flag: boolean=false;
  constructor(private vegetableService:VegetableserviceService) { }

  ngOnInit() {
  }

  public viewVegetableByCategory(category:string): void{
    this.flag=true;
    this.vegetableService.viewVegetableByCategory(this.vegetable.category).subscribe((p)=>{
      if(p["message"]!= undefined){
        this.msg= p["message"];
        alert(this.msg);
        this.flag=false;}
      else {
        this.vegetables=p;
      }
    });
  }
 

  public viewVegetableByName(name:string):void{
    this.flag=true;
    this.vegetableService.viewVegetableByName(this.vegetable.name).subscribe((p)=>{
      if(p["message"]!= undefined){
        this.msg= p["message"];
        alert(this.msg);
        this.flag=false;}
      else {
        this.vegetables=p;
      }
    });
  }

}
