import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ServiceCall } from 'src/app/models/service-call';
import { AddressService } from 'src/app/services/address.service';
import { CustomerService } from 'src/app/services/customer.service';
import { ServiceCallService } from 'src/app/services/service-call.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  calls: ServiceCall[] = [];

  constructor(
    private route: ActivatedRoute, private router: Router,
    private serviceCallService: ServiceCallService,) { }

    ngOnInit(): void {
      this.getActiveCalls();
    }

    getActiveCalls(){
      this.serviceCallService.getActiveServiceCalls().subscribe(
        {
        next: (serviceCalls) => {
          this.calls = serviceCalls;
        },
        error: (wrong) => {
          console.error('homeComponent.getActiveCalls(): Error retrieving calls');
          console.error(wrong);
          }
        }
      )
    }

    completeCall(call: ServiceCall): void {
      this.serviceCallService.updateServiceCall(call).subscribe({
        next: () => {
          this.getActiveCalls();
        },
        error: (fail) => {
          console.error("homeComponent.completeCall(): error updating call");
          console.error(fail);
        }
      });
    }

}
