import { Address } from "./address";

export class Customer {
  id: number;
  firstName: string;
  lastName: string;
  phoneNumber: number;
  addresses: Address[];

  constructor(id: number=0, firstName: string="", lastName: string="", phoneNumber: number=0, addresses: Address[]=[]){
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.addresses = addresses;
  }
}
