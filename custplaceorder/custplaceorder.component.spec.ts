import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustplaceorderComponent } from './custplaceorder.component';
import { RouterTestingModule } from '@angular/router/testing';
import { NO_ERRORS_SCHEMA, DebugElement } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule } from '@angular/forms';
import { Menu } from '../menu';
import { of } from 'rxjs';
import { MenuService } from '../menu.service';
import { OrderService } from '../order.service';
import { By } from '@angular/platform-browser';


describe('CustplaceorderComponent', () => {
  let service:MenuService;
  let service1:OrderService;
  let component: CustplaceorderComponent;
  let httpClient:HttpClient;
  let de: DebugElement;
  let el: HTMLElement;
  let fixture: ComponentFixture<CustplaceorderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustplaceorderComponent ],
      imports:[RouterTestingModule,HttpClientModule,HttpClientTestingModule,FormsModule],
      schemas:[NO_ERRORS_SCHEMA]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    service = new MenuService(httpClient);
    fixture = TestBed.createComponent(CustplaceorderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    de = fixture.debugElement.query(By.css('#placeorder'));
    el = de.nativeElement;

  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should call ngInit with success',() => {
    let menus:Menu[] = [
      new Menu(1000,'Idly',500,'veg',100,'Breakfast'),
      new Menu(1001,'Dosa',500,'veg',100,'lunch')
    ];
    localStorage.setItem('foodId','1000');
  spyOn(service,'getMenu').and.returnValue(of(menus));
  component.ngOnInit();
  expect(component.menus).not.toEqual(menus);
  expect(component.menus).not.toEqual(null);
});
it('should call place order',async()=>{
fixture.detectChanges();
spyOn(component,'addOrder');
el = fixture.debugElement.query(By.css("#placeorder")).nativeElement;
el.click();
expect(component.addOrder).toHaveBeenCalledTimes(1);
});
});
