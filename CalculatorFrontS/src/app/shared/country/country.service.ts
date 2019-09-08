import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Country} from '../../models/country.model';

@Injectable({
  providedIn: 'root'
})
export class CountryService {
  public PRODUCT_API = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  getAllCountries(): Observable<any> {
    return this.http.get(this.PRODUCT_API + '/list');
  }
  // TODO przy dodaniu kraju wypisać nazwy dostępnych walut z NBP!
  addCountry(country: Country) {
    return this.http.post(this.PRODUCT_API, country);
  }

  removeCountry(id: number) {
    return this.http.delete(this.PRODUCT_API + '/list/' + id);
  }

  updateCountry(country: Country) {
    return this.http.put(this.PRODUCT_API, country);
  }
}
