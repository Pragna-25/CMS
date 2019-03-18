import { TestBed } from '@angular/core/testing';
import { OrderService } from './order.service';
import { Order } from './order';
import { CustomerService } from './customer.service';

/*xdescribe('OrderService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: OrderService = TestBed.get(OrderService);
    expect(service).toBeTruthy();
  });
});*/

import { HttpClient } from '@angular/common/http';
import {
    HttpClientTestingModule,
    HttpTestingController
} from '@angular/common/http/testing';


import { Observable } from 'rxjs';

describe('OrderService', () => {
let service : OrderService;
let httpMock :HttpTestingController;
beforeEach(() => {
    TestBed.configureTestingModule({
    imports: [
    HttpClientTestingModule
    ],
    providers:[OrderService]
    });
    service = TestBed.get(OrderService);
    httpMock = TestBed.get(HttpTestingController);
});
it('mocking vendor history',()=>{
const mockstd:Order[] = [
new Order(1, 1002, 500, 1, 1, 'DELIVERED', 150, '14:55:29', '14:55:29', 
'thank you for visiting', '2019-02-19 14:55:29')
];
let vid='500';
service.getVendor(vid).subscribe(
    (data) => {
        expect(data.length).toBe(1);
        expect(data).toEqual(mockstd);
    });
    const request = httpMock.expectOne(service.venURL);
    expect(request.request.method).toBe('GET');
    request.flush(mockstd);
    });
    

it('mocking customer history',()=>{
    const mockstd:Order[] = [
        new Order(1, 1002, 500, 1, 1, 'DELIVERED', 150, '14:55:29', '14:55:29', 
        'thank you for visiting', '2019-02-19 14:55:29')
        ];
        let cid='1';
        service.getCustomer(cid).subscribe(
            (data) => {
                expect(data.length).toBe(1);
                expect(data).toEqual(mockstd);
            });
            const request = httpMock.expectOne(service.cusURL);
            expect(request.request.method).toBe('GET');
            request.flush(mockstd);
            });
            
it('mocking accept deny order',()=> {
           let or: Order;
           const orders:Order = new Order(2, 1001, 500, 1, 1, "DELIVERED", 400, "17:23:45", "17:23:45", 
           " thank you", "2019-03-13 17:23:45");
           service.postAcceptData(orders).subscribe(
           (data)=> {
              console.log(data);
              expect(data).toEqual(orders);
            });
            const request1 = httpMock.expectOne(service.ADurl);
            expect(request1.request.method).toBe('PUT');
            request1.flush(orders);
         });
            
it(' mocking place order',()=> {
    let or: Order;
            const orders:Order[] =[
                 new Order(3, 1002, 500, 1, 1, "PLACE_ORDER", 150, "17:25:19",
             "17:25:19", " ", "2019-03-13 17:25:19")
            ];
            service.postOrderData(orders).subscribe(
           (data)=> {
                console.log(data);
                expect(data).toEqual(orders);
            });
           const request1 = httpMock.expectOne(service.POurl);
           expect(request1.request.method).toBe('POST');
           request1.flush(orders);
        });
               
        it('should be created', () => {
            const service: OrderService = TestBed.get(OrderService);
            expect(service).toBeTruthy();
        });
               
        /*afterEach(() => { 
            httpMock.verify();
        });*/  
});
