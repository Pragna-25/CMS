import { Injectable } from '@angular/core';
import { Vendor } from './vendor';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Order } from './order';

@Injectable()
export class VendorService {
 
  vid: string;
  showvendorURL="http://localhost:8080/FTP106/api/vendor/500" ;
  constructor(private httpClient: HttpClient) {
  }
  public validateLogin(name: string, password: string): Observable<Vendor> {
    const params = new HttpParams()
      .set('vUserName', name)
      .set('vPassword', password);
    console.log(params.toString());

    return this.httpClient.get<Vendor>("http://localhost:8080/FTP106/api/vendor", { params });
  }

  //baseURL = "http://localhost:8080/FTP106/api/vendor/500" ;
  
  vendorInfo(vid: string): Observable<Vendor[]> {
    this.vid = localStorage.getItem('vid');
    let vurl ="http://localhost:8080/FTP106/api/vendor/" + vid;  
    console.log("i am here http get");

    return this.httpClient.get<Vendor[]>(vurl);

  }
  getPlacedOrder(vid: string): Observable<Order[]> {
    let url = "http://localhost:8080/FTP106/api/vendor/placedorder/" + localStorage.getItem('vid');
    return this.httpClient.get<Order[]>(url);
  }
}

