import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ShopComponent } from './components/shop/shop.component';
import { BlogComponent } from './components/blog/blog.component';
import { ContactComponent } from './components/contact/contact.component';
import { ReviewComponent } from './components/review/review.component';
import { AboutComponent } from './components/about/about.component';

import { UpdateComponent } from './update/update.component';

const routes: Routes = [
  {path:'home',component:HomeComponent},
  {path:'shop',component:ShopComponent},
  {path:'blog',component:BlogComponent},
  {path:'review',component:ReviewComponent},
  {path:'contact',component:ContactComponent},
  {path:'about',component:AboutComponent},
  {path:'',component:HomeComponent},

  {path:'update',component:UpdateComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
