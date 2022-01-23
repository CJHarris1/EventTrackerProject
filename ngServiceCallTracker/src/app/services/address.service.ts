import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { Address } from '../models/address';

@Injectable({
  providedIn: 'root'
})
export class AddressService {

  private baseUrl = 'http://localhost:8083/';
  private url = this.baseUrl + 'api/address';


  constructor(private http: HttpClient) { }

  getAddressByCustomerId(custId: number): Observable<Address[]> {
    return this.http.get<Address[]>(this.url + '/customer/' + custId).pipe(
      catchError( (error: any) => {
        console.error(error);
        return throwError(
          () => new Error(
            "AddressService.getAddressByCustomerId(): error getting address" + error
          )
        )
      })
    )
  }

  createAddress(address: Address): Observable<Address> {
    return this.http.post<Address>(this.url, address)
    .pipe(
      catchError( (error: any) => {
        console.error(error);
        return throwError(
          () => new Error(
            "AddressService.createAddress(): error creating address" + error
          )
        )
      })
    );
  }


}
