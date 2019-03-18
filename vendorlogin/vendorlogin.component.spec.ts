
import { VendorloginComponent } from './vendorlogin.component';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms'; // needed
import { DebugElement } from '@angular/core';
import { By } from '@angular/platform-browser';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
describe('VendorloginComponent', () => {
  let component: VendorloginComponent;
  let fixture: ComponentFixture<VendorloginComponent>;
  let de: DebugElement;
  let el: HTMLElement;

  
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VendorloginComponent ],
      imports: [ReactiveFormsModule, HttpClientModule],
      providers: [
        {provide: Router, useClass: MockRouter},
        {provide: ActivatedRoute, 
          useValue:
          {
            snapshot: {
              params: ({
                empId: 'emp101'
              })
            }
          }
        } //mockActiveRouter}
      ]
    })
    .compileComponents();
  }));
  class MockRouter {}  
  class MockActiveRouter {
  }
  beforeEach(() => {
    fixture = TestBed.createComponent(VendorloginComponent);
    component = fixture.componentInstance;
    de = fixture.debugElement.query(By.css('form'));
    el = de.nativeElement;
    fixture.detectChanges();
  });

  it('vendorlogin should create', () => {
    expect(component).toBeTruthy();
  });

  it('should call the OnSubmit method when submit button is clicked ', async() => {
    fixture.detectChanges();
    spyOn(component, 'onSubmit');
    el = fixture.debugElement.query ( By.css('button')).nativeElement;
    el.click();
    expect(component.onSubmit).toHaveBeenCalledTimes(1);
  });
  it('form should be invalid ', async() => {
    component.loginForm.controls['vUserName'].setValue('');
    component.loginForm.controls['vPassword'].setValue('');
    expect(component.loginForm.valid).toBeFalsy();
  });
  it('form should be valid ', async() => {
    component.loginForm.controls['vUserName'].setValue('rrrr');
    component.loginForm.controls['vPassword'].setValue('aaaa');
    expect(component.loginForm.valid).toBeTruthy();
  });
});
