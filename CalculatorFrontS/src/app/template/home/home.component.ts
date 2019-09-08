import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {HomeService} from '../../shared/home/home.service';
import {Country} from '../../models/country.model';
import {CountryService} from '../../shared/country/country.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  returnedData: any;
  countries: Country[];

  constructor(private formBuilder: FormBuilder, private router: Router, private homeService: HomeService,
              private countryService: CountryService) { }

  calculatorForm: FormGroup;

  ngOnInit() {
    this.countryService.getAllCountries().subscribe(data => { this.countries = data; });
    this.calculatorForm = this.formBuilder.group({
      countryId: ['', Validators.required],
      codeCurrency: ['', Validators.required],
      grossSalaryPerDay: ['', Validators.required]
    });
  }

  getCalculateData(): void {
    this.homeService.getSalary(this.calculatorForm.controls.countryId.value,
      this.calculatorForm.controls.grossSalaryPerDay.value)
      .subscribe(data => { this.returnedData = data; });
  }

}
