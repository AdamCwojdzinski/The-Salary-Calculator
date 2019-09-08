import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {HomeComponent} from './template/home/home.component';
import {CountryListComponent} from './components/country/country-list/country-list.component';
import {CountryAddComponent} from './components/country/country-add/country-add.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent},
  { path: 'countries', component: CountryListComponent},
  { path: 'country/new', component: CountryAddComponent}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
