import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-custdashboard',
  templateUrl: './custdashboard.component.html',
  styleUrls: ['./custdashboard.component.css']
})
export class CustdashboardComponent implements OnInit {
  cuserName:string;
  urlcus:any;
  constructor(public _router:Router,private _activatedRoute:ActivatedRoute) { }

  ngOnInit() {
    this.cuserName=localStorage.getItem('cuserName');
  
    this.urlcus=this._activatedRoute.snapshot.params['cid'];
    
    if(this.urlcus==localStorage.getItem('cid'))
    {
      this._router.navigate(['/custdashboard/',this.urlcus])
    }
    else
    {
      alert("authentication error");
      this._router.navigate(['/custlogin/'])
    }
  }

  logout():void{
    localStorage.removeItem('cid');
    this._router.navigate(['/home/']);
    console.log("homepage");
  }
}