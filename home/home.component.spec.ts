import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import{Router} from '@angular/router';
import { HomeComponent } from './home.component';
import { HttpClient } from '@angular/common/http';
import { MenuService } from '../menu.service';
import { Observable,of} from 'rxjs';
import { Menu } from '../menu';

describe('HomeComponent', () => {
  let component: HomeComponent;
  let fixture: ComponentFixture<HomeComponent>;
  let httpClient:HttpClient;
  let service:MenuService;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeComponent ],
  
    })
    .compileComponents();
  }));
  

  beforeEach(() => {
    service = new MenuService(httpClient);
    component = new HomeComponent(service);
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
  expect(component.menus).toEqual(menus);
  expect(component.menus).not.toEqual(null);
});
});
