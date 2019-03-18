import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WelcomevenComponent } from './welcomeven.component';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { VendorService } from '../vendor.service';
import { of } from 'rxjs';
import { Vendor } from '../vendor';

describe('WelcomevenComponent', () => {
  let component: WelcomevenComponent;
  let fixture: ComponentFixture<WelcomevenComponent>;
  let httpClient: HttpClient;
  let service: VendorService;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WelcomevenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    service = new VendorService(httpClient);
    component = new WelcomevenComponent(service);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it( 'vendor info mocking',() =>{
    let vendors:Vendor[]=[
      new Vendor(500, "KFC", "Deepak", "password", "deepak@kfc.com", 123123123, 
      "#123, 4th street,5th phase BTM, Bangalore, Karnataka")
    ]
    spyOn(service, 'vendorInfo').and.returnValue( of(vendors));
    component.ngOnInit();
    expect(component.vendors).toEqual(vendors);
    expect(component.vendors).not.toEqual(null);
    console.log('vendor info');
  })
});
