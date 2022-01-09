# EventTrackerProject

## Overview
This project is something that filled a void when I was working for my fathers HVAC company. My father kept track of every call and all customer records via paper notebooks and scheduling books. This application is designed to take the records of every day business and log them in a way that information about customers, addresses, equipment, and service calls are easily accessible and organized.

The backend is set up in a way that CRUD (create, read, update, delete) functions can be applied to the customer, address, the equipment inside of the house, and the service calls themselves. While we can delete the actual equipment in a scenario that it is replaced and no longer at the address, the rest of the information will be set as active or not active. We would always keep service call records even after completion so that they can be easily referenced back to when the customer calls again.

## REST API Reference
|  Return Type       |  HTTP Method  |         URI                           |  Request Body  |  Purpose  |
|--------------------|---------------|---------------------------------------|----------------|-----------|
| List\<Customer\>   |      GET      |  /api/customers                       |                |  List     |
| List\<Customer\>   |      GET      | /api/customers/firstname/{fName}      |                |  Retrieve |
| List\<Customer\>   |      GET      |   customers/lastname/{lName}          |                |  Retrieve |
| List\<Customer\>   |      GET      | /api/customers/phonenumber/{phone}    |                |  Retrieve |
|    Customer        |      POST     | /api/customers                        | Customer JSON  |  Create   |
|    Customer        |      PUT      | /api/customer/{custId}                |  Customer JSON | Update    |
| List\<Address\>    |      GET      | /api/address                          |                | List      |
| List\<Address\>    |      GET      | /api/address/city/{city}              |                | Retrieve  |
| List\<Address\>    |      GET      | /api/address/state/{state}            |                | Retrieve  |
| List\<Address\>    |      GET      |  /api/address/customer{custId}        |                | Retrieve  |
| Address            |      POST     |  /api/address                         | Address JSON   |   Create  |
| Address            |      PUT      | /api/address/{addrId}                 | Address JSON   |  Update   |
| List\<Equipment\>  |      GET      |  /api/equipment/{addrId}              |                |  Retrieve |
|   Equipment        |      POST     | /api/equipment                        | Equipment JSON | Create    |
| Equipment          |     PUT       | /api/equipment/{equipId}              | Equipment JSON | Update    |
| Void               |    DELETE     | /api/equipment/{equipId}              |                | Delete    |
| List\<ServiceCall\>|    GET        | /api/servicecalls                     |                | List      |
|List\<ServiceCall\> |    GET        | /api/servicecalls/datescheduled/{date}|                | Retrieve  |
|List\<ServiceCall\> |    GET        | /api/servicecalls/datecalled/{date}   |                | Retrieve  |
| ServiceCall        |    POST       |  /api/servicecalls                    |ServiceCall JSON| Create    |
| ServiceCall        |   PUT         | /api/servicecalls/{scId}              |ServiceCall JSON| Update    |
| ServiceCall        |   PUT         | /api/servicecalls/completed/{scId}    |                | Delete    |
|List\<ServiceCall\> |   GET         | /api/servicecalls/address/{addrId}    |                | Retrieve  |


## Technologies Used
mySQL workbench,
mySQL,
JPA/Hibernate,
RESTful API,
Java,
Spring Boot,
Github,
Gradle,
Postman,
MAMP,
AWS/EC2

## Lessons Learned
Lessons learned leaned heavily on proper planning for this project. With this being the first full-stack project I am doing alone I needed to carefully make sure my database schema included everything I wanted the site to accomplish. I needed to decide at the start how I wanted the service calls to be created, would they be created via the customer or the address? If a customer has multiple properties, how would I be able to create a call from a single customer and the call be for the correct house? After going back to the database a few times and tweaking the design, A customer will be the first thing created, from there, 1 or more addresses can be added to that customer and then 1 or more pieces of equipment can be added to the address. Service calls will be created from the address, eliminating any confusion and mix matched data. This is my first project using RESTful and learning the power of the repositories and services took some time to fully understand, but saved an incredible amount of time over using JPQL and writing a query for each method.
