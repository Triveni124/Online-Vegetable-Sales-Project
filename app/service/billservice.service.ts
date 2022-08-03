import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BillingDetails } from '../model/billing-details';
import { ProjectUrl } from '../project-url';

@Injectable({
  providedIn: 'root'
})
export class BillserviceService {
url:string=ProjectUrl.getUrl();
  constructor(private http:HttpClient) { }
  public Addbill(bill:BillingDetails):Observable<any>{
    return this.http.post<any>(this.url+"addBill",bill);
  }

  public getBillingDetailsById(billId:number):Observable<any>{
    return this.http.get<any>(this.url+"getBillingDetails/"+billId);
  }
  public updateBill(billingDetails:BillingDetails):Observable<any>{
    return this.http.put<any>(this.url+"updateBill",billingDetails);
  }

}
