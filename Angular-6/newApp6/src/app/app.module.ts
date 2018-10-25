import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {Route, RouterModule} from '@angular/router';

import { AppComponent } from './app.component';
import { HelloAngularComponent } from './hello-angular/hello-angular.component';
import { DateComponent } from './date/date.component';
import { AddressCardComponent } from './address-card/address-card.component';
import { NewModuleModule } from './new-module/new-module.module';
import { MyserviceService } from './myservice.service';
import { HomeComponent } from './home/home.component';
import { SettingsComponent } from './settings/settings.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { SettingsProfileComponent } from './settings-profile/settings-profile.component';
import { SettingsContactComponent } from './settings-contact/settings-contact.component';

const routes: Route[]=[
  {path:'',redirectTo:'/home', pathMatch:'full'},
  {path:'home',component:HomeComponent},
  {
    path:'settings',
    component:SettingsComponent,
    children:[
      {path:'',redirectTo:'profile',pathMatch:'full'},
      {path:'profile',component:SettingsProfileComponent},
      {path:'contact',component:SettingsContactComponent}
    ]
  },
  {path:'**',component:PageNotFoundComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    HelloAngularComponent,
    DateComponent,
    AddressCardComponent,
    HomeComponent,
    SettingsComponent,
    PageNotFoundComponent,
    SettingsProfileComponent,
    SettingsContactComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    NewModuleModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
  ],
  providers: [
    MyserviceService,
  ],
  exports:[RouterModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
