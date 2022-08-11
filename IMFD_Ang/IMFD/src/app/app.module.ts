import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { BlogComponent } from './components/blog/blog.component';
import { ContactComponent } from './components/contact/contact.component';
import { ReviewComponent } from './components/review/review.component';
import { ShopComponent } from './components/shop/shop.component';
import { FormsModule } from '@angular/forms';
import { AboutComponent } from './components/about/about.component';
import { CartService } from './cart.service';
import { ItemService } from './item.service';
import { LoginService } from './login.service';
import { CheckoutService } from './checkout.service';
import { CustomerService } from './customer.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    BlogComponent,
    ContactComponent,
    ReviewComponent,
    ShopComponent,
    AboutComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule],
  providers: [
    CartService,
    ItemService,
    LoginService,
    CheckoutService,
    CustomerService,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
