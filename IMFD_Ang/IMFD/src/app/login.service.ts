import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './customer';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root',
})
export class LoginService {
  public username: string;
  public password: string;
  baseUrl = environment.backendUrl;
  public currentUser: Customer = {
    customer_id: 1,
    firstname: '',
    lastname: '',
    address: '',
    phoneno: '',
    username: '',
    password: '',
  };
  constructor(private http: HttpClient) {}

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  loginCheck(uname: string, pass: string): Observable<Customer> {
    let passlower: string = pass.toLowerCase();
    let params = new HttpParams().set('uname', uname).set('pass', passlower);
    return this.http.get<Customer>(this.baseUrl + 'login', { params: params });
  }
}
