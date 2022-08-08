import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Cart } from './cart';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { core } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  baseurl = environment.backendUrl;

  constructor(private http:HttpClient) { }

  httpOptions={
    headers: new HttpHeaders({
      'Content-Type':'application/json'
    })
  }

  GetCarts():Observable<Cart[]>{
    return this.http.get<Cart[]>(this.baseurl+"cart")
  }


}
