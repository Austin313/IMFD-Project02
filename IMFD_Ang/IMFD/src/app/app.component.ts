import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'IMFD';
 
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


}


