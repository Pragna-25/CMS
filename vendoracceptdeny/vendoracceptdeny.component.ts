import { Component, OnInit } from '@angular/core';
import { VendorService } from '../vendor.service';
import { Vendor } from '../vendor';
import { Observable } from 'rxjs';
import { Order } from '../order';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-vendoracceptdeny',
  templateUrl: './vendoracceptdeny.component.html',
  styleUrls: ['./vendoracceptdeny.component.css'],
  providers: [VendorService, OrderService]
})
export class VendoracceptdenyComponent implements OnInit {
  vendors: Vendor[];
  orders: Order[];
  errorMsg: any;
  vid: string = "500";
  msg: string;
  poststr: string;
  postS: boolean;
  constructor(private _vendorService: VendorService, private orderService: OrderService) { }
  ngOnInit() {
    this._vendorService.getPlacedOrder(this.vid).subscribe(
      data => this.orders = data,
      error => this.errorMsg = error
    );
  }

  isChecked(orderId:string,ord:Order,checked:boolean)
  {
    ord.checked=checked;
    console.log('code'+orderId+'checked'+ord.checked);
  }

  accept(ost:string) {
    console.log("accepting");
    let order: Order;
    for (order of this.orders) {
    if (order.checked == true) {
      this.updateOrder(order.orderId, ost, order.oreason);
      alert("Accepted");
    }
  }
  window.location.reload();
}
  deny(ost:string) {
    console.log("deny");
    let order: Order;
    for (order of this.orders) {
      if (order.checked == true) {
        this.updateOrder(order.orderId, ost, order.oreason);
        alert("Denied");
      }
    }
    window.location.reload();
  }

  updateOrder(orderId:number,msg: string,oreason:string): any {
    console.log('Accepting Order');
    let or: Order = new Order(orderId, 0, 0, 0, 0, msg, 0, '00:00:00', '00:00:00', oreason, '0000-00-00');
    this.orderService.postAcceptData(or)
      .subscribe(
        data => {
          this.poststr = data;
          console.log("put success", data);
          this.postS = true;
        },
        error => {
          console.log("Error", error);
        }
      );
  }
}

