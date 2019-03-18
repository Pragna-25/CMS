import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-vendordashboard',
  templateUrl: './vendordashboard.component.html',
  styleUrls: ['./vendordashboard.component.css']
})
export class VendordashboardComponent implements OnInit {
  vname:string;
  urlvid:any;
  constructor(private _router:Router, private _activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.vname=localStorage.getItem('vname');
    
    this.urlvid=this._activatedRoute.snapshot.params['vid'];
    
    if(this.urlvid==localStorage.getItem('vid'))
    {
      this._router.navigate(['/vendashboard/',this.urlvid])
    }
    else
    {
      alert("authentication error");
      this._router.navigate(['/venlogin/'])
    }
  }
  logout():void{
    localStorage.removeItem('vid');
    this._router.navigate(['/home/']);
    console.log("homepage");
  }
}
