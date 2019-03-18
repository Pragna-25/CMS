import { Component, OnInit } from '@angular/core';
import { Menu } from '../menu';
import { MenuService } from '../menu.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers:[MenuService]
})
export class HomeComponent implements OnInit {
  menus: Menu[];
  username:string;
  errorMsg:any;
  constructor(private _menuService : MenuService) { }

  ngOnInit() {    
    this._menuService.getMenu().subscribe(
    data => this.menus = data,
    error => this.errorMsg = error
 );
  }

}

