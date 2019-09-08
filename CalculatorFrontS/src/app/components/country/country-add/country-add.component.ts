import { Component, OnInit } from '@angular/core';
import {Country} from '../../../models/country.model';
import {CountryService} from '../../../shared/country/country.service';
import {Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-country-add',
  templateUrl: './country-add.component.html',
  styleUrls: ['./country-add.component.css']
})
export class CountryAddComponent implements OnInit {

  country: Country;

  constructor(private formBuilder: FormBuilder, private countryService: CountryService, private router: Router) { }

  addCountryGroup: FormGroup;

  ngOnInit() {
    this.addCountryGroup = this.formBuilder.group({
      name: ['', Validators.required],
      rateCode: ['', Validators.required],
      tax: ['', Validators.required],
      fixedCost: ['', Validators.required]
    });
  }
// TODO walidacja formularzy
// TODO obsługa błędów z Springa
// TODO ładna prezentacja informacji o utworzeniu kraju
  onSubmitNewCountryForm(): void {
    this.countryService.addCountry(this.addCountryGroup.value)
      .subscribe(data => {
        this.router.navigate(['home']);
        alert('Dodano nowy kraj');
      });
  }

}
