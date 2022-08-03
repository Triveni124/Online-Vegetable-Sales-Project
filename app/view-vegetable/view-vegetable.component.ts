import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VegetableItem } from '../model/vegetableItem';
import { VegetableserviceService } from '../service/vegetableservice.service';

@Component({
  selector: 'app-view-vegetable',
  templateUrl: './view-vegetable.component.html',
  styleUrls: ['./view-vegetable.component.css']
})
export class ViewVegetableComponent implements OnInit {
vegetables:VegetableItem[]=[];
vegetable:VegetableItem=new VegetableItem();
msg:string="";
extractVegetable: any;

  constructor(private vegetableService:VegetableserviceService,private router:Router) { }

  ngOnInit() {
    this.vegetableService.extractVegetable().subscribe(
      response=>{
        this.vegetables=response;
      }
        
      
     );
  
  }
  public deletevegetable(vegetableId:number)
 {
    this.vegetableService.deleteVegetable(vegetableId).subscribe(
      response=>{
        console.log(response);
        this.msg=`${vegetableId}`+"deleted";
        alert("vegetable deleted");
        window.location.reload();

      }
    )
 }
 
}
