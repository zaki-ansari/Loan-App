import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateloanComponent } from './createloan/createloan.component';
import { DisplayloansComponent } from './displayloans/displayloans.component';
import { DisplayschedulesComponent } from './displayschedules/displayschedules.component';
import { HomeComponent } from './home/home.component';
import { HomescreenComponent } from './homescreen/homescreen.component';
import { LoginComponent } from './login/login.component';
import { NotfoundComponent } from './notfound/notfound.component';

const routes: Routes = [
  {
    path:"",redirectTo:"/homescreen",pathMatch:"full"
  },
  {
    path:"homescreen",component:HomescreenComponent
  },
  {
    path:"login",component:LoginComponent
  },
  {
    path:"home",component:HomeComponent
  },
  {
    path:"createloan",component:CreateloanComponent
  },
  {
    path:"displayschedules/:id",component:DisplayschedulesComponent
  },
  {
    path:"displayloans",component:DisplayloansComponent
  },
  {
    path:'**',component:NotfoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
