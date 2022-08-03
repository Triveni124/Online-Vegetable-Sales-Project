import { Injectable } from '@angular/core';
import { ProjectUrl } from '../project-url';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Admin } from '../model/admin';
//import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserserviceService {
url:string=ProjectUrl.getUrl();
  constructor(private http:HttpClient) { }

  public extractUser(email:string,password:string):Observable<any>{
    return this.http.get<any>(this.url+`user/login/${email}/${password}`);
  }

    public addUser(user:Admin):Observable<any>{  
      return this.http.post<any>(this.url+"addAdmin",user);
    }
    public extractAdmin():Observable<any>{
      return this.http.get<any>(this.url+"viewAdmin");
    }
    public deleteAdmin(adminId:number):Observable<any>{
       return this.http.delete<any>(this.url+`removeAdmin/${adminId}`)
    }
    public extractAdminById(adminId:number):Observable<any>{
      return this.http.get<any>(this.url+`fetch/admin/${adminId}`);
    }
    public updateAdminById(admin:Admin,adminId:number):Observable<any>{
      return this.http.put<any>(this.url+`updateAdmin/${adminId}`,admin);
    }
  }

