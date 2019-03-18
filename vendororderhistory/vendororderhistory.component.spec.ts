import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable,of } from 'rxjs';
import { VendororderhistoryComponent } from './vendororderhistory.component';
import { VendorService } from '../vendor.service';
import { OrderService } from '../order.service';
import { Order } from '../order';
import { HttpClient } from '@angular/common/http';

describe('VendororderhistoryComponent', () => {
  let component: VendororderhistoryComponent;
  let httpClient : HttpClient;
  let service : OrderService;
  let fixture: ComponentFixture<VendororderhistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VendororderhistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    service = new OrderService( httpClient);
    component = new VendororderhistoryComponent( service);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it( 'should call ngInit with success',() =>{
    let orders:Order[]=[
      new Order(18, 1000, 500, 2, 3, 'PLACE_ORDER', 240, '16:26:53', '16:26:53', ' ', '2019-03-12 16:26:53')
    ]
    spyOn(service, 'getVendor').and.returnValue( of(orders));
    component.ngOnInit();
    expect(component.orders).toEqual(orders);
    expect(component.orders).not.toEqual(null);
    console.log('vendor order history');
  })
});