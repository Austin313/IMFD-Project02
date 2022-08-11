import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  
 u_cust : Customer = {
  "customer_id":this.log.currentUser.customer_id,
  "firstname":this.log.currentUser.firstname,
  "lastname":this.log.currentUser.lastname,
  "username":this.log.currentUser.username,
  "password":this.log.currentUser.password,
  "address":this.log.currentUser.address,
  "phoneno":this.log.currentUser.phoneno
};
  constructor (private custservice:CustomerService, private log:LoginService){}

  ngOnInit(): void {
  
  }
  



 submitUpdate():any {
 //console.log(this.update_c)
  this.custservice.updateCustomer(this.u_cust).subscribe(data=>{console.log(data)});
  

 }
    
  }


