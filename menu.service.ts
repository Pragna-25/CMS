import { Injectable } from '@angular/core';
import { Menu } from './menu';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { isGeneratedFile } from '@angular/compiler/src/aot/util';

@Injectable()
export class MenuService {
  constructor(private httpClient: HttpClient) { }
  public baseURL = 'http://localhost:8080/FTP106/api/menu';
  
  getMenu() : Observable<Menu[]> {
    console.log("I am here http get");
    let myurl = this.baseURL;
    return this.httpClient.get<Menu[]>(myurl);  
}
 
}

