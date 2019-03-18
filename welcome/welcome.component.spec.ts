import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WelcomeComponent } from './welcome.component';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { CustomerService } from '../customer.service';
import { Customer } from '../customer';
import { of } from 'rxjs';

describe('WelcomevenComponent', () => {
  let component: WelcomeComponent;
  let fixture: ComponentFixture<WelcomeComponent>;
  let httpClient: HttpClient;
  let service: CustomerService;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WelcomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    service = new CustomerService(httpClient);
    component = new WelcomeComponent(service);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it( 'customer info mocking',() =>{
    let customers:Customer[]=[
      new Customer("1", "JOHN", "JOHN", 7586469254, "JOHN@GMAIL.COM", "10", "JOHN@123")
    ]
    spyOn(service, 'customerInfo').and.returnValue( of(customers));
    component.ngOnInit();
    expect(component.customers).toEqual(customers);
    expect(component.customers).not.toEqual(null);
    console.log('customer info');
  })
});
