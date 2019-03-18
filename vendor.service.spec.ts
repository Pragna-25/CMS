import { TestBed } from '@angular/core/testing';

import { VendorService } from './vendor.service';
import { Vendor } from './vendor';
import { HttpTestingController, HttpClientTestingModule } from '@angular/common/http/testing';


  describe('VendorService', () => {
    let service : VendorService;
    let httpMock :HttpTestingController;
    beforeEach(() => { 
                TestBed.configureTestingModule({
                  imports: [
                    HttpClientTestingModule
                  ],
                  providers:[VendorService]
                });          
                service = TestBed.get(VendorService);
                httpMock = TestBed.get(HttpTestingController);
              });
          
  it('mocking vendor info',()=>{
    const vendors:Vendor[] = [
      new Vendor(500, 'Deepak','Deepak', 'password',  'JOHN@gmail.com',456456,  '2dgfsdfgf')
    ];
    service.vendorInfo('500').subscribe(
      (data) => {
        expect(data.length).toBe(1);
        expect(data).toEqual(vendors);
      });
    const request = httpMock.expectOne(service.showvendorURL);
    expect(request.request.method).toBe('GET');
    request.flush(vendors);

  });
  afterEach(() => { 
    httpMock.verify();
  });
    
});
