import { Component, OnInit } from '@angular/core';
import { Vendor } from '../vendor';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { VendorService } from '../vendor.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-vendorlogin',
  templateUrl: './vendorlogin.component.html',
  styleUrls: ['./vendorlogin.component.css'],
  providers: [VendorService]
})
export class VendorloginComponent implements OnInit {

  loginForm: FormGroup;
  submitted = false;
  stdlogin: Vendor;
  loaded: boolean = false;
  myvendor: Vendor;
  errMsg: string;
  customerLogin: Vendor[] = [];

  constructor(private formBuilder: FormBuilder,
    private ls: VendorService,
    public _router: Router) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      vUserName: ['', Validators.required],
      vPassword: ['', [Validators.required]]
    });
  }

  get f(){return this.loginForm.controls;}
  
  onSubmit(){
    let venlogin:Vendor;
    venlogin=this.loginForm.value;
    this.ls.validateLogin(venlogin.vUserName,venlogin.vPassword).subscribe(
    data=>{
      this.loaded=true;
      this.myvendor=data;
      console.log(this.myvendor);
     
      localStorage.setItem('vid',this.myvendor.vid + "");
      localStorage.setItem('vname',this.myvendor.vname + "");
      localStorage.setItem('vusername',this.myvendor.vUserName + "");
      localStorage.setItem('vphone',this.myvendor.vphone + "");
      localStorage.setItem('vemail',this.myvendor.vEmail + "");
      alert('Welcome to'+" "+this.myvendor.vname);
      this._router.navigate(['/vendashboard/',this.myvendor.vid]);
     
    },
    error=>{
      this.errMsg=error;
      console.log(this.errMsg);
      alert('Invalid details');
    });
}

}