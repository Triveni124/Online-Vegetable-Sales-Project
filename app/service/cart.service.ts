import { Injectable } from '@angular/core';
import { ProjectUrl } from '../project-url';
import {HttpClient} from '@angular/common/http';
import { Cart } from '../model/cart';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class CartService {

  url:string=ProjectUrl.getUrl();
  getVegetableById: any;
  deleteAll: any;
  constructor(private http:HttpClient) { }

  public addToCart(cart:Cart):Observable<any>{
    return this.http.post<any>(this.url+"addCart",cart);
  }
 public increaseVegQuantity(quantity:number,vegetableId:number):Observable<any>{
   return this.http.put<any>(this.url+`IncreaseVegQuantity/${quantity}/${vegetableId}`,quantity);
 }
 public DecreaseVegQuantity(quantity:number,vegetableId:number):Observable<any>{
 return this.http.put<any>(this.url+`DecreaseVegQuantity/${quantity}/${vegetableId}`,quantity);
 }
 // public removeCart(id:number):Observable<any>{
 //   return this.http.delete<any>(this.url+`deleteCart/${id}`);
 // }
 public removeAllVegetable():Observable<any>{
  return this.http.delete<any>(this.url+"removeAllVegetable");
   }
 // public viewAllItems():Observable<any>{
  //  return this.http.get<any>(this.url+"viewAll");
  //}
}
