import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Customer} from '../../customer';
import { CustomerService } from '../../customer.service';
import { LoginService } from 'src/app/login.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  public customer: Customer;
  constructor(private cs:CustomerService,private login:LoginService){}

  ngOnInit(){
  
    this.cs.GetCustomer(this.login.username).subscribe(data=>{
      this.customer=data;
    })
  }

}
