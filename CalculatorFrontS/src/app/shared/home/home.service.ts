import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HomeService {
  public PRODUCT_API = '/api';

  constructor(private http: HttpClient) { }

  getSalary(id: string, dailyPay: string) {
    const params = new HttpParams()
      .set('id', id)
      .set('dailyPay', dailyPay);
    return this.http.get(this.PRODUCT_API + '/calculate', {params});
  }
}
