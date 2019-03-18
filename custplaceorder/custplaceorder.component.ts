import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Order } from '../order';
import { OrderService } from '../order.service';
import { Menu } from '../menu';
import { MenuService } from '../menu.service';
import { Customer } from '../customer';
import { finalize } from 'rxjs/operators';


@Component({
  selector: 'app-custplaceorder',
  templateUrl: './custplaceorder.component.html',
  styleUrls: ['./custplaceorder.component.css'],
  providers:[MenuService],
  styles: [`
  .ng-invalid {
    border: 2px solid: red;
  
  };
  .ng-valid {
    border: 2px solid : green;
  };
  `]
})
export class CustplaceorderComponent implements OnInit {
  menus: Menu[];
  username:string;
  errorMsg:any;
  newMenu: any;
  _router: any;
  menu: any;
  loaded:boolean = false;
  postS:boolean = false;
  poststr:any ='';
  f: number;
  q: number;
  cid:number;
  prevVal : boolean = false;
  curVal : boolean = false;
  ordArr : Order[]=[];
  constructor(private router:Router,private orderService:OrderService,private _menuService : MenuService) { }

  ngOnInit() {
    this._menuService.getMenu().subscribe(
    data => this.menus = data,
    error => this.errorMsg = error
  );
  }

  addOrder()
  {
    let menu:Menu;
    let cusid : any;

    cusid = localStorage.getItem('cid')
    for (menu of this.menus){
    if(menu.isSelected == true) {
      this.f= menu.foodId;
      this.q=menu.qty;
      let or: Order = new Order(0,this.f,0,cusid,this.q,'PLACE_ORDER',0,'00:00:00','00:00:00','Thank you for visiting','0000-00-00');
      this.ordArr.push( or );
    }
  }
  if ( this.ordArr.length > 0 ){
    this.addOrderByRest();
  }
  }
  
  addOrderByRest() : any {
 
    console.log('Placing Order');

    this.orderService.postOrderData(this.ordArr)
    .pipe( 
        finalize(() => {
          console.log('finalize is called')
          this.curVal = true;
          }
        )
      )   
    .subscribe(
      data => {
        this.poststr = data;
        console.log("post success",data);
        alert("   " + this.poststr.msg);
        this.postS = true;
        window.location.reload();
      },
      error => {
        console.log("Error",error);
        this.postS = true;
        window.location.reload();
      }
    );
  }
  toggleSelect(menu : Menu ,argSel:boolean){
    menu.isSelected = argSel;
  }
  calc(menu:Menu):number{
    let calc:number = 0;
    if ( menu.isSelected){
      if ( menu.qty > 0){
        calc = +(menu.qty) * +(menu.foodPrice);
        menu.tPrice = calc;
        console.log(menu.tPrice);
      }
    }
    return calc;
  }
  gotoPlaceOrder():void{
      this._router.navigate(['/custplaceorder'])
    }
    trackByFn(index:Number,menu:Menu){
      return menu;
    }

}















  



