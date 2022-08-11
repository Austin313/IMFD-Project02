import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders, HttpParams } from '@angular/common/http';
import { Cart } from './cart';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { core, DeclareVarStmt } from '@angular/compiler';
import { LoginService } from './login.service';
import { CustomerService } from './customer.service';
import { ItemService } from './item.service';
import { Customer } from './customer';
import { Item } from './item';

@Injectable({
  providedIn: 'root'
})
export class CartService  {

  baseurl = environment.backendUrl;

  cust:number;
  itemno:number;


  constructor(private http:HttpClient,private log:LoginService,private c:CustomerService) { }



  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':'application/json'
    })
  }

  GetCarts():Observable<Cart[]>{
    return this.http.get<Cart[]>(this.baseurl+"cart")
  }

  increaseQ():Observable<any>{
    let params = new HttpParams()
    .set('cust', this.cust)
    .set('item', this.itemno);
    return this.http.put<any>(this.baseurl+"increase",{params: params})
  }

  addToCart(cart:Cart):Observable<Cart>{
    return this.http.post<Cart>(this.baseurl+"cart/add", cart)
  }

  removeCart(cust:number,item:number):Observable<any>{
    let params = new HttpParams()
    .set('cust', cust)
    .set('item', item)
    return this.http.delete<any>(this.baseurl+"delete", {params:params})
  }

}
