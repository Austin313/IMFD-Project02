import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Order } from './order';

@Injectable({
  providedIn: 'root',
})
export class CheckoutService {
  constructor(private http: HttpClient) {}
  baseURL: string = environment.backendUrl;

  httpOptions = {
    headers: new Headers({
      'Content-Type': 'application/json',
    }),
  };

  checkout(order: Order): Observable<Order> {
    return this.http.post<Order>(this.baseURL + 'checkout', order);
  }
}
