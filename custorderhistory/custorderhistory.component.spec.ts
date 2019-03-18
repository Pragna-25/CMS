import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { CustorderhistoryComponent } from './custorderhistory.component';
import { HttpClient } from '@angular/common/http';

import { Order } from '../order';
import { of } from 'rxjs';
import { OrderService } from '../order.service';


describe('CustorderhistoryComponent', () => {
  let component: CustorderhistoryComponent;
  let fixture: ComponentFixture<CustorderhistoryComponent>;
  let httpClient: HttpClient;
  let service: OrderService;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustorderhistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    service = new OrderService(httpClient);
    component = new CustorderhistoryComponent(service);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it( 'customer order history mocking',() =>{
    let orders:Order[]=[
      new Order(18, 1000, 500, 2, 3, 'PLACE_ORDER', 240, '16:26:53', '16:26:53', ' ', '2019-03-12 16:26:53')
    ]
    spyOn(service, 'getCustomer').and.returnValue( of(orders));
    component.ngOnInit();
    expect(component.orders).toEqual(orders);
    expect(component.orders).not.toEqual(null);
    console.log('customer order history');
  })
});

