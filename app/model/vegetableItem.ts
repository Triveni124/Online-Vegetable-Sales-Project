import { Cart } from "./cart";

export class VegetableItem {

    public vegetableId:number;
    public name:string;
    public category:string;
    public price:number;
    public quantity:number;
    public cart:Cart=new Cart();
  getVegetableById: any;

}
