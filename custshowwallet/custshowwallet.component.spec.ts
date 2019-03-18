import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustshowwalletComponent } from './custshowwallet.component';
import { CustomerService } from '../customer.service';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Customer } from '../customer';

describe('CustshowwalletComponent', () => {
  let component: CustshowwalletComponent;
  let service: CustomerService;
  let httpClient: HttpClient;
  let fixture: ComponentFixture<CustshowwalletComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [CustshowwalletComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    service = new CustomerService(httpClient);
    component = new CustshowwalletComponent(service);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should call ngInit with success', () => {
    let wallet: Customer[] = [
      new Customer('3', 'JOHN', 'JOHN', 2342345, 'JOHN@gmail.com', '1000', 'JOHN@123')
    ];

    localStorage.setItem('cid', '3');
    spyOn(service, 'getWallet').and.returnValue(of(wallet));
    component.ngOnInit();
    expect(component.wallet).toEqual(wallet);
    expect(component.wallet).not.toEqual(null);
  });
});

