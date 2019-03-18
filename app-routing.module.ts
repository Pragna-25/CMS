import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CustdashboardComponent } from './custdashboard/custdashboard.component';
import { CustplaceorderComponent } from './custplaceorder/custplaceorder.component';
import { VendordashboardComponent } from './vendordashboard/vendordashboard.component';
import { VendororderhistoryComponent } from './vendororderhistory/vendororderhistory.component';
import { VendoracceptdenyComponent } from './vendoracceptdeny/vendoracceptdeny.component';
import { CustorderhistoryComponent } from './custorderhistory/custorderhistory.component';
import { CustshowwalletComponent } from './custshowwallet/custshowwallet.component';
import { HomeComponent } from './home/home.component';
import { VendorloginComponent } from './vendorlogin/vendorlogin.component';
import { CustloginComponent } from './custlogin/custlogin.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { WelcomevenComponent } from './welcomeven/welcomeven.component';


export const CHILD_ROUTES: Routes = [
  { path: 'custplaceorder', component: CustplaceorderComponent },
  { path: 'custorderhistory', component: CustorderhistoryComponent },
  { path: '', component: WelcomeComponent },
  { path: 'custshowwallet', component: CustshowwalletComponent },
  { path: 'Logout', redirectTo: '/home', pathMatch: 'full' }
  ];
export const CHILD_ROUTES_1: Routes = [
  { path: 'vendororderhistory', component: VendororderhistoryComponent },
  { path: 'vendoracceptdeny', component: VendoracceptdenyComponent },
  { path: '', component: WelcomevenComponent },
  { path: 'Logout', redirectTo: '/home', pathMatch: 'full' }
];


const routes: Routes = [
  { path: 'vendashboard/:vid', component: VendordashboardComponent, children: CHILD_ROUTES_1 },
  { path: 'custdashboard/:cid', component: CustdashboardComponent, children: CHILD_ROUTES },
  { path: 'home', component: HomeComponent },
  { path: 'venlogin', component: VendorloginComponent },
  { path: 'custlogin', component: CustloginComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '**', redirectTo: '/home', pathMatch: 'full' }
];
//localhost:4200/custdashboard/custorderhistory
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
