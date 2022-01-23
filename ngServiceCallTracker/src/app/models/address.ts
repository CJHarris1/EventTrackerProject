import { Customer } from "./customer";
import { ServiceCall } from "./service-call";

export class Address {
  id: number;
  address: string;
  city: string;
  stateAbbv : string;
  serviceCalls: ServiceCall[];
  customer: Customer;

  constructor(id: number=0, address: string="", city: string="", stateAbbv: string="", serviceCalls: ServiceCall[] =[], customer: Customer = new Customer()) {
    this.id = id;
    this.address = address;
    this.city = city;
    this.stateAbbv = stateAbbv;
    this.serviceCalls = serviceCalls;
    this.customer = customer;
  }
}
