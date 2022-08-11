import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Cart } from './cart';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { core, DeclareVarStmt } from '@angular/compiler';
import { LoginService } from './login.service';
import { CustomerService } from './customer.service';

@Injectable({
  providedIn: 'root',
})
export class CartService {
  baseurl = environment.backendUrl;

  constructor(
    private http: HttpClient,
    private log: LoginService,
    private c: CustomerService
  ) {}

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  GetCarts(cust: number): Observable<Cart[]> {
    let params = new HttpParams().set('cust', cust);
    return this.http.get<Cart[]>(this.baseurl + 'cart', { params: params });
  }

  increaseQ(cust: number, item: number): Observable<any> {
    let params = new HttpParams().set('cust', cust).set('item', item);
    alert(cust + ' ' + item);
    return this.http.delete<any>(this.baseurl + 'cart/increase', {
      params: params,
    });
  }

  decreaseQ(cust: number, item: number): Observable<any> {
    let params = new HttpParams().set('cust', cust).set('item', item);
    return this.http.delete<any>(this.baseurl + 'cart/decrease', {
      params: params,
    });
  }

  addToCart(cart: Cart): Observable<Cart> {
    return this.http.post<Cart>(this.baseurl + 'cart/add', cart);
  }

  removeCart(cust: number, item: number): Observable<any> {
    let params = new HttpParams().set('cust', cust).set('item', item);
    return this.http.delete<any>(this.baseurl + 'cart/delete', {
      params: params,
    });
  }

  clearCart(cust: number): Observable<any> {
    let params = new HttpParams().set('cust', cust);
    return this.http.delete<any>(this.baseurl + 'cart/clear', {
      params: params,
    });
  }
}
