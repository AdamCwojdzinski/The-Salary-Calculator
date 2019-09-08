import { Component, OnInit } from '@angular/core';
import {Country} from '../../../models/country.model';
import {CountryService} from '../../../shared/country/country.service';
import {Router} from '@angular/router';
import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-country-edit',
  templateUrl: './country-edit.component.html',
  styleUrls: ['./country-edit.component.css']
})
export class CountryEditComponent implements OnInit {

  country: Country;

  constructor(private formBuilder: FormBuilder, private countryService: CountryService, private router: Router) {}

  editCountryGroup: FormGroup;

  ngOnInit() {

  }

}
