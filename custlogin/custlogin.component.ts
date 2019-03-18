import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-custlogin',
  templateUrl: './custlogin.component.html',
  styleUrls: ['./custlogin.component.css'],
  providers: [CustomerService]

})
export class CustloginComponent implements OnInit {

  loginForm: FormGroup;
  submitted = false;
  stdlogin: Customer;
  loaded: boolean = false;
  mycustomer: Customer;
  errMsg: string;
  customerLogin: Customer[] = [];


  constructor(private formBuilder: FormBuilder,
    private ls: CustomerService,
    public _router: Router) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      cuserName: ['', Validators.required],
      cPassword: ['', [Validators.required]]
    });
  }

  //convenience getter for easy access to form fields
  get f() { return this.loginForm.controls; }


  onSubmit() {
    let cuslogin: Customer;
    cuslogin = this.loginForm.value;
    this.ls.validateLogin(cuslogin.cuserName, cuslogin.cPassword).subscribe(
      data => {
        this.loaded = true;
        this.mycustomer = data;
        console.log(this.mycustomer);
        alert('Welcome '+this.mycustomer.cuserName);
        localStorage.setItem('cid', this.mycustomer.cid);
        localStorage.setItem('cName', this.mycustomer.cName + "");
        localStorage.setItem('cuserName', this.mycustomer.cuserName + "");
        localStorage.setItem('cPhonee', this.mycustomer.cPhone + "");
        localStorage.setItem('cEmail', this.mycustomer.cEmail + "");
        this._router.navigate(['/custdashboard/', this.mycustomer.cid]);

        console.log(this.mycustomer.cuserName);

      },
      error => {
        this.errMsg = error;
        console.log(this.errMsg);
        alert('Invalid details');
      });

  }
}

