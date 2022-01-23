import { DatePipe } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { ServiceCall } from '../models/service-call';

@Injectable({
  providedIn: 'root'
})
export class ServiceCallService {

  private baseUrl = 'http://localhost:8083/';
  private url = this.baseUrl + 'api/servicecalls';

  constructor(private datePipe : DatePipe, private http: HttpClient) { }

  createServiceCall(call: ServiceCall):Observable<ServiceCall>{
    let date = this.datePipe.transform(Date.now(), 'yyyy-MM-dd');
       if(date !== null){
        call.dateCalled = date;
       }
    return this.http.post<ServiceCall>(this.url, call)
    .pipe(
      catchError((error: any) => {
        console.error(error);
        return throwError(
          () => new Error("ServiceCallService.createServiceCall(); error creating service call" + error)
        )
      })
    );
  }

  getActiveServiceCalls():Observable<ServiceCall[]>{
    return this.http.get<ServiceCall[]>(this.url + "/active").pipe(
      catchError( (error:any) => {
        console.error(error);
        return throwError(
        () => new Error( "serviceCallService.getAllServiceCall(): error getting calls" + error)
        )
      })
    );
  }

  updateServiceCall(call: ServiceCall){
    return this.http.put<ServiceCall>(this.url + "/completed/" + call.id, call).pipe(
      catchError( (error: any) => {
        console.error("TodoService.update(): error updating todo:");
        console.error(error);
        return throwError(
          () => new Error(
            "TodoService.update(): error updating todo"
          )
        )
      }
    ));
  }


}
