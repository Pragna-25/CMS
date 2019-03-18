import { Component, OnInit } from '@angular/core';
import { Vendor } from '../vendor';
import { Observable } from 'rxjs';
import { OrderService } from '../order.service';
import { Order } from '../order';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-vendororderhistory',
  templateUrl: './vendororderhistory.component.html',
  styleUrls: ['./vendororderhistory.component.css'],
  providers:[OrderService]
})
export class VendororderhistoryComponent implements OnInit {

  orders: Order[];
  errorMsg:any;
  vid: string;
  constructor( private _orderService: OrderService) { }

  ngOnInit() {
    this.vid=localStorage.getItem('vid');
    this._orderService.getVendor(this.vid).subscribe(
    data => this.orders = data,
    error => this.errorMsg = error
   );
  }

}
