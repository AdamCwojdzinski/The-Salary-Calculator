import { Component, OnInit } from '@angular/core';
import {Country} from '../../../models/country.model';
import {CountryService} from '../../../shared/country/country.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-country-list',
  templateUrl: './country-list.component.html',
  styleUrls: ['./country-list.component.css']
})
export class CountryListComponent implements OnInit {

  countries: Country[];

  constructor(private countryService: CountryService, private router: Router ) { }

  ngOnInit() {
    this.showListOfCountries();
  }

  showListOfCountries(): void {
    this.countryService.getAllCountries()
      .subscribe(data => { this.countries = data; });
  }
// TODO implemectacja edit
  editCountry(country: any) {
   return null; }

  removeCountry(country: any) {
    this.countryService.removeCountry(country.id).subscribe(),
      alert('Państwo usunięte'),
      this.showListOfCountries();
  }
}
