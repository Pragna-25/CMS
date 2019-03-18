import { Component, OnInit } from '@angular/core';
import { Vendor } from '../vendor';
import { VendorService } from '../vendor.service';

@Component({
  selector: 'app-welcomeven',
  templateUrl: './welcomeven.component.html',
  styleUrls: ['./welcomeven.component.css'],
  providers: [VendorService]
})
export class WelcomevenComponent implements OnInit {

  vid: string;
  vname: string;
  vusername: string;
  vphone: string;
  vemail: string;
  vendors: Vendor[];
  errorMsg: any;
  
  constructor(private _vendorService: VendorService) { }

  ngOnInit() {
    this.vid = localStorage.getItem('vid');
    this.vname = localStorage.getItem('vname');
    this.vusername = localStorage.getItem('vusername');
    this.vphone = localStorage.getItem('vphone');
    this.vemail = localStorage.getItem('vemail');
    this._vendorService.vendorInfo(this.vid).subscribe(
      data => this.vendors = data,
      error => this.errorMsg = error
    );
  }
}
