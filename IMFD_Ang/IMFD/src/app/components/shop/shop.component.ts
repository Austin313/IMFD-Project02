import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { ItemService } from 'src/app/item.service';
import { Item } from 'src/app/item';


@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {
  public items: Item[];
  constructor(private is:ItemService) { }

  ngOnInit(): void {
    this.is.GetItems().subscribe(data=>{
      this.items=data;
    })
  }

}
