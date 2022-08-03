import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../model/customer';
import { ProjectUrl } from '../project-url';

@Injectable({
  providedIn: 'root'
})
export class CustomerserviceService {
  url:string=ProjectUrl.getUrl();
  constructor(private http:HttpClient) { }
  public AddCustomer(customer:Customer):Observable<any>{
    return this.http.post(this.url+"addCustomer", customer,{responseType:'text'});
  }

    public viewCustomerByCity(city:string):Observable<any>{
      return this.http.get<any>(this.url+"viewCustomerList/"+city);
    }

    public getCustomerById(customerId:number):Observable<any>{
      return this.http.get<any>(this.url+"getCustomer/"+customerId);
    }
    public Updatecustomer(customer:Customer):Observable<any>{
      return this.http.put<any>(this.url+"updateCustomer",customer);
    }
    public viewAllCustomers():Observable<any>{
      return this.http.get<any>(this.url+"viewAllCustomers");
    }
    public deleteCustomer(customerId:number):Observable<any>{
      return this.http.delete<any>(this.url+`removeCustomer/${customerId}`)
    }

  }

