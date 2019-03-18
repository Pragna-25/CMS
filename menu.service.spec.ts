
import { TestBed , inject } from '@angular/core/testing';
import {   HttpClient } from '@angular/common/http';

import {
  HttpClientTestingModule,
  HttpTestingController
} from '@angular/common/http/testing';

import { MenuService } from './menu.service';
import { Observable } from 'rxjs';
import { Menu } from './menu';


describe('MenuService', () => {
  let service : MenuService;
  let httpMock :HttpTestingController;
  beforeEach(() => { 
              TestBed.configureTestingModule({
                imports: [
                  HttpClientTestingModule
                ],
                providers:[MenuService]
              });          
              service = TestBed.get(MenuService);
              httpMock = TestBed.get(HttpTestingController);
            });
        
  it('http method get menu',()=>{
    const menus:Menu[] = [
      new Menu(1000,'Idly',500,'veg',100,'Breakfast'),
      new Menu(1001,'Dosa',500,'veg',100,'lunch')
    ];
    service.getMenu().subscribe(
      (data) => {
        expect(data.length).toBe(2);
        expect(data).toEqual(menus);
      });
    const request = httpMock.expectOne(service.baseURL);
    expect(request.request.method).toBe('GET');
    request.flush(menus);

  });
  afterEach(() => { 
    httpMock.verify();
  });
    
});