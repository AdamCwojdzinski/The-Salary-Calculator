import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {ReactiveFormsModule} from '@angular/forms';
import {AppRoutingModule} from './app.routing';
import {HttpClientModule} from '@angular/common/http';
import { NavbarComponent } from './template/navbar/navbar.component';
import { FooterComponent } from './template/footer/footer.component';
import { HomeComponent } from './template/home/home.component';
import { CountryAddComponent } from './components/country/country-add/country-add.component';
import { CountryEditComponent } from './components/country/country-edit/country-edit.component';
import { CountryListComponent } from './components/country/country-list/country-list.component';
import {HomeService} from './shared/home/home.service';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    HomeComponent,
    CountryAddComponent,
    CountryEditComponent,
    CountryListComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [HomeService],
  bootstrap: [AppComponent]
})
export class AppModule {

}
