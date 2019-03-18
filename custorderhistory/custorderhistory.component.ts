import { Component, OnInit } from '@angular/core';
import { Order } from '../order';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-custorderhistory',
  templateUrl: './custorderhistory.component.html',
  styleUrls: ['./custorderhistory.component.css'],
  providers: [OrderService]
})
export class CustorderhistoryComponent implements OnInit {

  orders: Order[];
  errorMsg:any;
  cid:string;
  constructor( private _orderService: OrderService) { }

  ngOnInit() {
    this.cid=localStorage.getItem('cid');
    this._orderService.getCustomer(this.cid).subscribe(
      data => this.orders = data,
      error => this.errorMsg = error
     );
  }
 
}
