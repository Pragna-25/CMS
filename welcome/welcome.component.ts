import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css'],
  providers: [CustomerService]
})
export class WelcomeComponent implements OnInit {

  cid: string;
  cname: string;
  cuserName : string;
 
  cphone : string;
  cemail : string;
  customers: Customer[];
  errorMsg:any;
  constructor(private _customerService: CustomerService) { }

  ngOnInit() {
    this.cid=localStorage.getItem('cid');
    this.cname=localStorage.getItem('cname');
    this.cuserName=localStorage.getItem('cuserName');
    
    this.cphone=localStorage.getItem('cphone');
    this.cemail=localStorage.getItem('cemail');
    this._customerService.customerInfo(this.cid).subscribe(
      data => this.customers = data,
      error => this.errorMsg = error
     );
  }

}
