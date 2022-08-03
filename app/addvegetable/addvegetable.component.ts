import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VegetableItem } from '../model/vegetableItem';
import { VegetableserviceService } from '../service/vegetableservice.service';
import { ViewVegetableComponent } from '../view-vegetable/view-vegetable.component';

@Component({
  selector: 'app-addvegetable',
  templateUrl: './addvegetable.component.html',
  styleUrls: ['./addvegetable.component.css']
})
export class AddvegetableComponent implements OnInit {
vegetable:VegetableItem=new VegetableItem();
  constructor(private vegetableService:VegetableserviceService,private router:Router) { }

  ngOnInit() {
  }

  public addVegetable():void{
    console.log(this.vegetable);
    this.vegetableService.addVegetable(this.vegetable).subscribe((p)=>
    {
     // this.msg=p['message'];
      //console.log(this.msg);
      alert("vegetable added");
      this.router.navigate(['Add Vegetable']);
    }
  );

  }

}
