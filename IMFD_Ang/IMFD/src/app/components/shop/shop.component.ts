import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { ItemService } from 'src/app/item.service';
import { Item } from 'src/app/item';
import { Cart } from 'src/app/cart';
import { CartService } from 'src/app/cart.service';
import { LoginService } from 'src/app/login.service';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {
  public items: Item[];
  custnum:number = this.l.currentUser.customer_id;
  newCart:Cart;
  confirm:boolean = false;
  quan:number =0;

   selectedItem:Item = {
    "itemno": 0,
    "itemType":"",
    "itemname":"",
    "itemPrice": 0

  }
  
  
  constructor(private is:ItemService, private l:LoginService,private cart:CartService) { }
  
  
 

  ngOnInit(): void {
    this.is.GetItems().subscribe(data=>{
      this.items=data;
    })
    

    this.newCart = {
      customer: this.l.currentUser.customer_id,
      itemId: 0,
      itemName: '',
      itemPrice: 0,
      quantity: 0
    }


    
  
  }

  getItem(index:number):any{
    const id = this.items.map((i) =>{
       return i.itemno;
       })
    this.is.GetItem(id[index]).subscribe(data => {
      this.selectedItem = data
      this.confirm = true;
      alert(this.selectedItem.itemname+1111111111)
    })
  }


  addCart():any{
    this.newCart.itemId = this.selectedItem.itemno;
    alert(this.newCart.itemId)
    this.newCart.itemPrice = this.selectedItem.itemPrice;
    this.newCart.itemName = this.selectedItem.itemname;
    this.newCart.quantity = this.quan;
    this.cart.addToCart(this.newCart).subscribe();
    this.quan = 0;
    this.confirm = false;
    
  }
  




  //   async addCart(index:number):Promise<any>{
  //   const id = this.items.map((i) =>{
  //     return i.itemno;
  //   })
  //   alert(id)
  //   alert("before call of this.getItem")
  //   this.is.GetItem(id[index]).subscribe(data => {
  //       alert("before selected item is defined");
  //       this.selectedItem = data;
  //     })
  //   alert("this comes after getitem method")
  //   alert(this.selectedItem.itemname)
  //   this.newCart.itemId = this.selectedItem.itemno;
  //   this.newCart.itemName = this.selectedItem.itemname;
  //   this.newCart.itemPrice = this.selectedItem.itemPrice;
  //   this.newCart.quantity = 1;
  //   alert(this.newCart.itemId)
  //   alert(this.newCart.customer)
  //   this.newCart.quantity = 1;
  //   //do method here
  //   this.cart.addToCart(this.newCart).subscribe();
  //   //reset quantity to 0
  //   this.newCart.quantity = 0;
  // }


}
