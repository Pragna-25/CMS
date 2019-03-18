import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-custshowwallet',
  templateUrl: './custshowwallet.component.html',
  styleUrls: ['./custshowwallet.component.css']
})
export class CustshowwalletComponent implements OnInit {

  customers: Customer[];
  wallet:any;
  errorMsg:any;
  cid:string;
  
  constructor( private _customerService: CustomerService) { }

  ngOnInit() {
    this.cid=localStorage.getItem('cid');
    this._customerService.getWallet(this.cid).subscribe(
      data => this.wallet = data,
      error => this.errorMsg = error
     );
     
  }

}
