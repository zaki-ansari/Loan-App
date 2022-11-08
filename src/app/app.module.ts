import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { CreateloanComponent } from './createloan/createloan.component';
import { FormsModule} from '@angular/forms';
import { MaterialModule } from './shared/material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { DisplayschedulesComponent } from './displayschedules/displayschedules.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { DisplayloansComponent } from './displayloans/displayloans.component';
import { ToastrModule } from 'ngx-toastr';
import { ModalModule } from 'ngx-bootstrap/modal';
import { DatePipe } from '@angular/common';
import { HomescreenComponent } from './homescreen/homescreen.component';
import { MatDialogSignupComponent } from './mat-dialog-signup/mat-dialog-signup.component';
import { MatDialogSigninComponent } from './mat-dialog-signin/mat-dialog-signin.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NotfoundComponent,
    HomeComponent,
    HeaderComponent,
    CreateloanComponent,
    DisplayschedulesComponent,
    DisplayloansComponent,
    HomescreenComponent,
    MatDialogSignupComponent,
    MatDialogSigninComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    MaterialModule,
    BrowserAnimationsModule,
    HttpClientModule,
    NgxPaginationModule,
    ModalModule.forRoot(),
    ToastrModule.forRoot({
      timeOut:5000,
      positionClass:'toast-top-center',
      preventDuplicates:true
    })
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
