import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { LoginService } from './login.service';
import { Customer } from './customer';
import { CustomerService } from './customer.service';
import { ThisReceiver } from '@angular/compiler';
import { CartService } from './cart.service';
import { Cart } from './cart';
import { Order } from './order';
import { CheckoutService } from './checkout.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'IMFD app is running!';
  public customer: Customer;
  public order: Order = {
    subtotal: 0,
    total: 0,
  };

  public uname: string = '';
  public pass: string = '';
  public isLoggedIn: boolean = false;
  public isNull: boolean = false;
  public temp: number = 0;
  public reg: boolean = false;
  public test: string = '';
  public editProfile: boolean = false;
  //=====================
  public firstname: string = '';
  public lastname: string = '';
  public username: string = '';
  public password: string = '';
  public phone: string = '';
  public street: string = '';
  public state: string = '';
  public zip: string = '';
  public address: string = this.street + ' ' + this.state + ' ' + this.zip;
  //==============================
  public carts: Cart[];

  constructor(
    private login: LoginService,
    private cust: CustomerService,
    private cart: CartService,
    private check: CheckoutService
  ) {}

  //total method
  public total: number = 0;
  public temporary: number = 0;
  calculateTotal(): any {
    this.total = 0;
    for (var j: number = 0; j < this.carts.length; j++) {
      this.temporary = this.carts[j].itemPrice * this.carts[j].quantity;
      this.total += this.temporary;
    }
  }

  //=============================

  newCustomer = {
    customer_id: 0,
    firstname: '',
    lastname: '',
    username: '',
    password: '',
    address: '',
    phoneno: '',
  };

  navButton() {
    const loginForm = document.querySelector('.login-form') as HTMLFormElement;
    const loginButton = document.querySelector('#login-btn') as HTMLDivElement;
    const navbar = document.querySelector('.navbar') as HTMLElement;
    const cart = document.querySelector('.shopping-cart') as HTMLDivElement;
    const searchForm = document.querySelector(
      '.search-form'
    ) as HTMLFormElement;
    const cartBtn = document.querySelector('#cart-btn') as HTMLDivElement;
    const searchButton = document.querySelector(
      '#search-btn'
    ) as HTMLDivElement;
    const menuBtn = document.querySelector('#menu-btn') as HTMLDivElement;
    loginButton.onclick = () => {
      loginForm.classList.toggle('active');
      searchForm.classList.remove('active');
      cart.classList.remove('active');
      navbar.classList.remove('active');
    };

    cartBtn.onclick = () => {
      cart.classList.toggle('active');
      searchForm.classList.remove('active');
      loginForm.classList.remove('active');
      navbar.classList.remove('active');
    };

    searchButton.onclick = () => {
      searchForm.classList.toggle('active');
      cart.classList.remove('active');
      loginForm.classList.remove('active');
      navbar.classList.remove('active');
    };
    menuBtn.onclick = () => {
      navbar.classList.toggle('active');
      searchForm.classList.remove('active');
      cart.classList.remove('active');
      loginForm.classList.remove('active');
    };
    window.onscroll = () => {
      searchForm.classList.remove('active');
      cart.classList.remove('active');
      loginForm.classList.remove('active');
      navbar.classList.remove('active');
    };
  }

  profileEdit(): any {
    this.editProfile = true;
    this.isLoggedIn = true;
  }

  updateCustomer(): any {
    let updatedCust: Customer = {
      customer_id: this.customer.customer_id,
      firstname: this.firstname,
      lastname: '',
      address: '',
      phoneno: '',
      username: '',
      password: '',
    };
  }

  //login verification
  loginClick(): any {
    this.login.loginCheck(this.uname, this.pass).subscribe((data) => {
      this.customer = data;
      this.temp = 1;
      this.login.currentUser = data;
      this.logValid();
    });
  }

  logValid(): any {
    if (this.customer == null && this.temp == 1) {
      this.isNull = true;
      this.temp = 0;
      this.pass = '';
    } else {
      this.isLoggedIn = true;
    }
  }

  logOut(): any {
    this.isLoggedIn = false;
    this.isNull = false;
    this.customer;
    this.pass = '';
    this.uname = '';
    this.login.currentUser = {
      customer_id: 0,
      firstname: '',
      lastname: '',
      address: '',
      phoneno: '',
      username: '',
      password: '',
    };
  }

  //register

  needRegister(): any {
    this.reg = true;
    this.isLoggedIn = false;
  }

  submitRegister(): any {
    this.cust.addCustomer(this.newCustomer).subscribe();
    this.reg = false;
  }

  cancelReg(): any {
    this.reg = false;
  }

  //Cart

  loadCart(): any {
    this.cart.GetCarts(this.login.currentUser.customer_id).subscribe((data) => {
      this.carts = data;
    });
    this.calculateTotal();
  }

  removeCart(index: number): any {
    const cust = this.carts.map((c) => {
      return c.customer;
    });
    const item = this.carts.map((c) => {
      return c.itemId;
    });

    this.cart.removeCart(cust[index], item[index]).subscribe(() => {
      console.log('cart deleted');
    });
  }


  updateLink():void{
  
  this.router.navigate(['/update']);
  }

  increaseQ(index: number): any {
    const cust = this.carts.map((c) => {
      return c.customer;
    });
    const item = this.carts.map((c) => {
      return c.itemId;
    });
    this.cart.increaseQ(cust[index], item[index]).subscribe(() => {
      console.log('added 1 to ' + cust);
    });
  }


  decreaseQ(index: number): any {
    const cust = this.carts.map((c) => {
      return c.customer;
    });
    const item = this.carts.map((c) => {
      return c.itemId;
    });
    this.cart.decreaseQ(cust[index], item[index]).subscribe(() => {
      console.log('took away 1 to ' + cust);
    });
  }

  //Checkout!!!

  checkout(): any {
    this.order.subtotal = this.total;
    this.order.total = this.order.subtotal * 1.0825;
    alert(this.order.subtotal);
    this.check.checkout(this.order).subscribe((data) => {
      this.order = data;
    });
    this.cart.clearCart(this.customer.customer_id).subscribe(() => {
      console.log('Clearing cart');
    });
  }
}
