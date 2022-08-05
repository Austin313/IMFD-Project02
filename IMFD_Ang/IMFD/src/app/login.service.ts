import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './customer';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class LoginService {
  public username:string;
  public password:string;
  baseUrl= environment.backendUrl
  constructor(private http:HttpClient) {
   }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':'application/json'
    })
  }
  
loginCheck(uname:string):Observable<Customer>{
  let params = new HttpParams()
  .set('uname', this.username)
  .set('pass', this.password);
  alert(this.username)
  return this.http.get<Customer>(this.baseUrl+"login",{params: params})
}

}
