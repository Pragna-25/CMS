import { Injectable } from '@angular/core';
import { Order } from './order';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Vendor } from './vendor';
import { delay } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  vid: string;
  cid : string;
 venURL =  "http://localhost:8080/FTP106/api/order/ven/500";
  cusURL = "http://localhost:8080/FTP106/api/order/cus/1";
  ADurl =  'http://localhost:8080/FTP106/api/vendor/modify/2';
  //POurl = 'http://localhost:8080/FTP106/api/customer/placeorder/1';
  
  public ordArr : Order[];
   constructor(private httpClient: HttpClient) { }

  getVendor(vid: string): Observable<Order[]> {
    let url = "http://localhost:8080/FTP106/api/order/ven/" + vid;
    return this.httpClient.get<Order[]>(url);
  }

 
  getCustomer(cid: string) : Observable<Order[]> {
   // this.cid=localStorage.getItem('cid');
     let url = "http://localhost:8080/FTP106/api/order/cus/" + cid;
      return this.httpClient.get<Order[]>(url);
        }


  POurl = 'http://localhost:8080/FTP106/api/customer/placeorder/';
  postOrderData(or: Order[]): Observable<any> {
       this.POurl = this.POurl +localStorage.getItem('cid');
       return this.httpClient.post(this.POurl,or);
  }

  public getOrders(): Order[] 
  {
    return this.ordArr;
  }
  
  public  AddOrder(ord: Order):void
  {
   this.ordArr.push(ord);
  }
  
  public postAcceptData(or: Order): any 
  {
    let url = 'http://localhost:8080/FTP106/api/vendor/modify/'+or.orderId;
    return this.httpClient.put(url,or);
  }
  
  
}
