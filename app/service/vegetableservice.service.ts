import { Injectable } from '@angular/core';
import { ProjectUrl} from '../project-url';
import{HttpClient} from '@angular/common/http';

import { Observable } from 'rxjs';
import { VegetableItem } from '../model/vegetableItem';

@Injectable({
  providedIn: 'root'
})
export class VegetableserviceService {

  url:string=ProjectUrl.getUrl();
  constructor(private http:HttpClient) { }
  public addVegetable(vegetable:VegetableItem):Observable<any>
  {
     return this.http.post(this.url+"addVegetable", vegetable,{responseType:'text'});
  }
  
  public extractVegetable():Observable<any>
  {
    return this.http.get<any>(this.url+"viewAllvegetable");
  }
 
  public viewVegetableByCategory(category:string): Observable<any>{
    return this.http.get<any>(this.url+"viewvegetablesList/"+category)  
  }

  public viewVegetableByName(name:string): Observable<any>{
    return this.http.get<any>(this.url+"viewvegetableByName/"+name)  
  }

  public updateVegetable(vegetable:VegetableItem):Observable<any>{
    return this.http.put<any>(this.url+"updateVegetable",vegetable);
  }

  public deleteVegetable(vegetableId:number):Observable<any>{
    return this.http.delete<any>(this.url+`removeVegetable/${vegetableId}`)
  }

  public getVegetableById(vegetableId:number):Observable<any>{
    return this.http.get<any>(this.url+`getVegetableId/${vegetableId}`);
  }
}
