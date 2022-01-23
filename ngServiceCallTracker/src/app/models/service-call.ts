import { Address } from "./address";

export class ServiceCall {
  id: number;
  description: string ;
  dateCalled: string ;
  dateScheduled: string ;
  timeSlot: number ;
  active: boolean ;
  address: Address ;

  constructor(id: number=0, description: string="", dateCalled: string="", dateScheduled: string="", timeSlot: number=0, active: boolean=true, address: Address= new Address()) {
    this.id = id;
    this.description = description;
    this.dateCalled = dateCalled;
    this.dateScheduled = dateScheduled;
    this.timeSlot = timeSlot;
    this.active = active;
    this.address = address;
  }
}
