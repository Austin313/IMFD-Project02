import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { LoginService } from './login.service';
import { Customer } from './customer';
import { CustomerService } from './customer.service';
import { ThisReceiver } from '@angular/compiler';
import { CartService } from './cart.service';
import { Cart } from './cart';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnChanges{
  title = 'IMFD';
  public customer:Customer;
 
  public uname:string = "";
  public pass:string = "";
  public isLoggedIn:boolean = false;
  public isNull:boolean = false;
  public temp:number = 0;
  public reg:boolean = false;
  public test:string = "";
  //=====================
  public firstname:string ="";
  public lastname:string ="";
  public username:string ="";
  public password:string ="";
  public phone:string ="";
  public street:string ="";
  public state:string ="";
  public zip:string = "";
  public address:string = this.street+" "+this.state+" "+this.zip;
  //==============================
  public carts:Cart[];
  
  constructor(private login:LoginService, private cust:CustomerService, private cart:CartService){
    
  }

//total method
public total:number = 0;
public temporary:number = 0;
calculateTotal():any{
  for(var j:number = 0; j < this.carts.length; j++){
    this.temporary = this.carts[j].itemPrice * this.carts[j].quantity
    this.total += this.temporary
  }
}











//=============================


  ngOnChanges(): void {
   
  }
  

  

  ngOnInit():void{
    
  }
  
   newCustomer= {
    "customer_id":0,
    "firstname":'',
    "lastname":'',
    "username":'',
    "password":'',
    "address":'',
    "phoneno":''
  }

  navButton(){
  const loginForm = document.querySelector('.login-form') as HTMLFormElement;
  const loginButton= document.querySelector('#login-btn') as HTMLDivElement;
  const navbar = document.querySelector('.navbar') as HTMLElement;
  const cart = document.querySelector('.shopping-cart') as HTMLDivElement;
  const searchForm = document.querySelector('.search-form') as HTMLFormElement;
  const cartBtn = document.querySelector('#cart-btn') as HTMLDivElement;
  const searchButton =document.querySelector('#search-btn') as HTMLDivElement;
  const menuBtn = document.querySelector('#menu-btn') as HTMLDivElement;
    loginButton.onclick = () =>{
    loginForm.classList.toggle('active');
    searchForm.classList.remove('active');
    cart.classList.remove('active');
    navbar.classList.remove('active');
    }

    cartBtn.onclick = () =>{
      cart.classList.toggle('active');
      searchForm.classList.remove('active');
      loginForm.classList.remove('active');
      navbar.classList.remove('active');
  }

  searchButton.onclick = () =>{
    searchForm.classList.toggle('active');
    cart.classList.remove('active');
    loginForm.classList.remove('active');
    navbar.classList.remove('active');
  }
  menuBtn.onclick = () =>{
  navbar.classList.toggle('active');
  searchForm.classList.remove('active');
  cart.classList.remove('active');
  loginForm.classList.remove('active');
    
  }
  window.onscroll = () =>{
    searchForm.classList.remove('active');
    cart.classList.remove('active');
    loginForm.classList.remove('active');
    navbar.classList.remove('active');
}


}





//login verification
 loginClick():any{
  this.login.loginCheck(this.uname,this.pass).subscribe(data=>{
    this.customer = data;
    this.temp = 1;
    this.login.currentUser = data;
    this.logValid();
  });
  
}

 logValid():any{
  if(this.customer == null && this.temp == 1){
    this.isNull = true;
    this.temp = 0;
    this.pass = "";
  } else {
    this.isLoggedIn = true;
  }
  
 }
 
 
 logOut():any{
  this.isLoggedIn = false;
  this.isNull = false;
  this.customer;
  this.pass = "";
  this.uname = "";
 }

 //register

 needRegister():any {
  this.reg = true;
  this.isLoggedIn = false;
  
 }

 submitRegister():any {
 
  this.cust.addCustomer(this.newCustomer).subscribe();
  this.reg = false;

 }


 //Cart

 loadCart():any{
  this.cart.GetCarts().subscribe(data =>{
    this.carts=data;
  })
  this.calculateTotal();
}

removeCart(index:number):any{
  const cust = this.carts.map((c) =>{
     return c.customer;
  })
  const item = this.carts.map((c) =>{
    return c.itemId;
 })
  this.cart.removeCart(cust[index],item[index]).subscribe();
  
}



 
}


