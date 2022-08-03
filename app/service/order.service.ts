import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../model/order';
import { ProjectUrl } from '../project-url';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  url:string=ProjectUrl.getUrl();
  deleteShow: any;
  orderList: any;
  getorderById: any;
  
 


  constructor(private http:HttpClient) { }
  public addOrder(order:Order):Observable<any>
  {
    return this.http.post(this.url+"addorder", order,{responseType:'text'});
  }
  //extracting product
  public extractOrder():Observable<any>
  {
    return this.http.get<any>(this.url+"viewAllorders");
  }

  public viewOrderList():Observable<any>
  {
    return this.http.get<any>(this.url+"orderList");
  }

   public getOrderById(orderId:number):Observable<any>
  {
    return this.http.get<any>(this.url+`/getOrderById/${orderId}`);
  }


  public viewOrderById(id:number):Observable<any>{
    return this.http.get<any>(this.url+`viewOrder/${id}`);
  }

  public viewOrderByDate(date:number):Observable<any>
  {
    return this.http.get<any>(this.url+`viewOrders/${date}`);
  }

  public Updateorder(order:Order):Observable<any>
  {
    return this.http.put<any>(this.url+"updateOrder",order);

  }

   public cancelOrder(orderId:number):Observable<any>
  {
    return this.http.delete<any>(this.url+`cancelOrder/${orderId}`);
  }
}
