import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Customer } from '../models/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  // private baseUrl = 'http://localhost:8083/';
  private url = environment.baseUrl + 'api/customers';

  constructor(private http: HttpClient) { }

  searchFullName(){}

  searchFirstName(){}

  searchLastName(){}

  searchAllCustomers(): Observable<Customer[]>{
    return this.http.get<Customer[]>(this.url)
    .pipe(
      catchError( (error: any) => {
        console.error(error);
        return throwError(
          () => new Error(
            "CustomerService.searchAllCustomers(): error getting todos" + error
          )
        )
      })
    );
  }






}
