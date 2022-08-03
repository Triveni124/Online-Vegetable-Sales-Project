import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


import { ProjectUrl } from '../project-url';
import { HttpClient } from '@angular/common/http';
import { VegetableItem } from '../model/vegetableItem';

@Injectable({
  providedIn: 'root'
})
export class VegetableService {

  url: string=ProjectUrl.getUrl();

  constructor(private http:HttpClient) { }

  public addVegetable(vegetable:VegetableItem):Observable<any>
  {
     return this.http.post<any>(this.url+"addVegetable", vegetable);
  }
  
  public extractVegetable():Observable<any>
  {
    return this.http.get(this.url+"viewAllvegetable")
}
public deleteVegetable(vegetableId:number):Observable<any>{
  return this.http.delete<any>(this.url+`removeVegetable/${vegetableId}`)
}
  public getVegetableById(vegetableId:number):Observable<any>{
    return this.http.get<any>(this.url+`getVegetableId/${vegetableId}`);
  }
 
}
