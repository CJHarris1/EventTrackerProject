import { Component, OnInit } from '@angular/core';
import { Address } from 'src/app/models/address';
import { Customer } from 'src/app/models/customer';
import { ServiceCall } from 'src/app/models/service-call';
import { AddressService } from 'src/app/services/address.service';
import { CustomerService } from 'src/app/services/customer.service';
import { ServiceCallService } from 'src/app/services/service-call.service';

@Component({
  selector: 'app-search-existing',
  templateUrl: './search-existing.component.html',
  styleUrls: ['./search-existing.component.css']
})
export class SearchExistingComponent implements OnInit {

  customer: Customer = new Customer();

  newAddress: Address = new Address();

  serviceCall: ServiceCall = new ServiceCall();

  customers: Customer[] = [];

  addresses: Address[] | null= [];

  selectedCustomer: Customer | null = null;

  selectedAddress: Address | null = null;

  showResults: boolean = false;

  showAddressForm: boolean = false;

  constructor(private customerService: CustomerService, private addressService: AddressService, private serviceCallService: ServiceCallService) { }

  ngOnInit(): void {
  }

  searchCustomer(customer: Customer){
    this.customerService.searchAllCustomers().subscribe({
      next: (foundCustomers) => {
        this.customers = foundCustomers;
        this.showResults = true;

      },
      error: (wrong) => {
        console.error("search-exiting.component.searchCustomer(): Error retrieving customers");
        console.error(wrong);
      }
    });
  }

  getAddresses(cust : Customer){
    this.addresses = null;
    this.showAddressForm = false;
    this.selectedCustomer=cust;
    this.addressService.getAddressByCustomerId(cust.id).subscribe({
      next: (foundAddresses) => {
        this.addresses = foundAddresses;
      },
      error: (wrong) => {
        console.error("search-exiting.component.getAddresses(): Error retrieving addresses");
        console.error(wrong);
      }
    });
  }

  addNewAddress(address: Address){
    if(this.selectedCustomer){
      address.customer = this.selectedCustomer;
    }
    console.log(address);

    this.addressService.createAddress(address).subscribe(
      {
      next: (todo) => {
        this.newAddress = new Address();
      },
      error: (fail) => {
        console.error("search-existingCompnent.addNewAddress(): Error creating address");
        console.error(fail);
        }
      }
    );
  }

  addNewServiceCall(call : ServiceCall){
    if(this.selectedAddress){
      call.address = this.selectedAddress;
    }
    this.serviceCallService.createServiceCall(call).subscribe({
      next: (newCall) => {
        this.serviceCall = new ServiceCall();
      },
      error: (fail) => {
        console.error("searchExistingComponent.addNewServiceCall(): Error creating service call");
        console.error(fail);
      }
    })
  }



}
