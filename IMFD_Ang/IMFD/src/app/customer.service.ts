import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs';
import { Customer } from './customer';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  baseurl= environment.backendUrl;

  constructor(private http:HttpClient) { }

  

  httpOptions = {
    headers: new HttpHeaders({
      'Content-type':'application/json'
    })
  }

  GetCustomer(uname:string): Observable<Customer>{
    return this.http.get<Customer>(this.baseurl+"profile/"+uname)
  }

  addCustomer(customer:Customer): Observable<Customer>{
      return this.http.post<Customer>(this.baseurl+"customer", customer)
    }
}
