import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { CustloginComponent } from './custlogin/custlogin.component';
import { VendorloginComponent } from './vendorlogin/vendorlogin.component';
import { CustdashboardComponent } from './custdashboard/custdashboard.component';
import { VendordashboardComponent } from './vendordashboard/vendordashboard.component';
import { CustorderhistoryComponent } from './custorderhistory/custorderhistory.component';
import { VendororderhistoryComponent } from './vendororderhistory/vendororderhistory.component';
import { VendoracceptdenyComponent } from './vendoracceptdeny/vendoracceptdeny.component';
import { CustshowwalletComponent } from './custshowwallet/custshowwallet.component';
import { CustplaceorderComponent } from './custplaceorder/custplaceorder.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { WelcomeComponent } from './welcome/welcome.component';
import { HttpClientModule } from '@angular/common/http';
import { WelcomevenComponent } from './welcomeven/welcomeven.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CustloginComponent,
    VendorloginComponent,
    CustdashboardComponent,
    VendordashboardComponent,
    CustorderhistoryComponent,
    VendororderhistoryComponent,
    VendoracceptdenyComponent,
    CustshowwalletComponent,
    CustplaceorderComponent,
    WelcomeComponent,
    WelcomevenComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    ],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
