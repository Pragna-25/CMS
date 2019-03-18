import { TestBed } from '@angular/core/testing';
import { CustomerService } from './customer.service';
import {   HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './customer';
import {
  HttpClientTestingModule,
  HttpTestingController
} from '@angular/common/http/testing';



describe('CustomerService', () => {
  let service : CustomerService;
  let httpMock :HttpTestingController;
  beforeEach(() => { 
              TestBed.configureTestingModule({
                imports: [
                  HttpClientTestingModule
                ],
                providers:[CustomerService]
              });          
              service = TestBed.get(CustomerService);
              httpMock = TestBed.get(HttpTestingController);
            });
        
  it('mocking customer wallet ',()=>{
    const wallet:Customer[] = [
      new Customer('1', 'JOHN', 'JOHN', 2342345, 'JOHN@gmail.com', '1000', 'JOHN@123')
    ];
    service.getWallet('1').subscribe(
      (data) => {
        expect(data.length).toBe(1);
        expect(data).toEqual(wallet);
      });
    const request = httpMock.expectOne(service.showWalletURL);
    expect(request.request.method).toBe('GET');
    request.flush(wallet);

  });
  afterEach(() => { 
    httpMock.verify();
  });
  it('mocking customer info',()=>{
    const wallet:Customer[] = [
      new Customer('1', 'JOHN', 'JOHN', 2342345, 'JOHN@gmail.com', '1000', 'JOHN@123')
    ];
    service.customerInfo('1').subscribe(
      (data) => {
        expect(data.length).toBe(1);
        expect(data).toEqual(wallet);
      });
    const request = httpMock.expectOne(service.showcustomerinfo);
    expect(request.request.method).toBe('GET');
    request.flush(wallet);

  });
  afterEach(() => { 
    httpMock.verify();
  });
    
    
});