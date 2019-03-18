import { Injectable } from '@angular/core';
import { Customer } from './customer';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from './order';
@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  showWalletURL="http://localhost:8080/FTP106/api/customer/wallet/1";
  showcustomerinfo="http://localhost:8080/FTP106/api/customer/1";
cid:string;
  constructor(private httpClient: HttpClient) { }
  
      public validateLogin(name:string,password:string):Observable<Customer>
      {
       const params = new HttpParams()
       .set('cUserName',name)
       .set('cPassword',password);
       console.log(params.toString());
   
        return this.httpClient.get<Customer>("http://localhost:8080/FTP106/api/customer",{params});
      } 
      
public getWallet(cid: string) : Observable<Customer[]> {
  this.cid=localStorage.getItem('cid');
  let myurl1 ="http://localhost:8080/FTP106/api/customer/wallet/"+cid;
  console.log("wallet info");
  return this.httpClient.get<Customer[]>(myurl1);
}
      


  public customerInfo(cid: string) : Observable<Customer[]>
  {
    this.cid=localStorage.getItem('cid');
    let myurl= "http://localhost:8080/FTP106/api/customer/" +cid;;
    console.log("customer info");
    return this.httpClient.get<Customer[]>(myurl);
    
    }
    
  
}
