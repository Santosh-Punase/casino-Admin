import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {HttpModule} from '@angular/http';
import { UserLoginComponent } from './user-login/user-login.component';
import { DashboardComponent } from './user-login/dashboard/dashboard.component';
import {RouterModule} from '@angular/router';
import {RoulleteServiceService} from './roullete-service.service';
import {FormsModule} from '@angular/forms';

const app_routes = [
  {path: 'login', component: UserLoginComponent},
  {path: 'dashboard', component: DashboardComponent},
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: '**', redirectTo: '/login', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    UserLoginComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot(app_routes)
  ],
  providers: [RoulleteServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
