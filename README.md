# EventTrackerProject

## Overview
This project is something that filled a void when I was working for my fathers HVAC company. My father kept track of every call and all customer records via paper notebooks and scheduling books. This application is designed to take the records of every day business and log them in a way that information about customers, addresses, equipment, and service calls are easily accessible and organized.

The backend is set up in a way that CRUD (create, read, update, delete) functions can be applied to the customer, address, the equipment inside of the house, and the service calls themselves. While we can delete the actual equipment in a scenario that it is replaced and no longer at the address, the rest of the information will be set as active or not active. We would always keep service call records even after completion so that they can be easily referenced back to when the customer calls again.

The frontend is set up for to give the user the ability to search for customers by first name, last name, both, or if the search is left blank, will pull every customer in the records. If the customer the user is looking for does not exist, user can add a new customer. Once the customer exists you have the ability to add an address or view addresses already linked to the customer. While viewing the customer addresses you can choose an address to add a service call to. Service calls are linked to an address over the customer because some customers would have multiple properties and need the ability to add a service call to the correct address. When the page first loads, todays calls are displayed. The user also has the ability to view all active calls. Once a call is completed, the user can click the completed button and the service call will no longer appear on the calls list. Due to call information, customer records, and addresses being valuable, I decided to leave the delete portion of CRUD out at this point in time. I will add the equipment entity in the future where the delete option will exist to delete equipment from a house. An update is in place to complete a call and set the status of the call to completed.

![servicecallsdb](https://user-images.githubusercontent.com/88620365/148706305-c6377723-84d4-490a-85dd-e857ecbae119.png)

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
JavaScript,
Html,
CSS,
VS Code,
Spring Boot,
Github,
Gradle,
Postman,
MAMP,
AWS/EC2

## Lessons Learned
January 8 and January 9, 2022
Lessons learned leaned heavily on proper planning for this project. With this being the first full-stack project I am doing alone I needed to carefully make sure my database schema included everything I wanted the site to accomplish. I needed to decide at the start how I wanted the service calls to be created, would they be created via the customer or the address? If a customer has multiple properties, how would I be able to create a call from a single customer and the call be for the correct house? After going back to the database a few times and tweaking the design, A customer will be the first thing created, from there, 1 or more addresses can be added to that customer and then 1 or more pieces of equipment can be added to the address. Service calls will be created from the address, eliminating any confusion and mix matched data. This is my first project using RESTful and learning the power of the repositories and services took some time to fully understand, but saved an incredible amount of time over using JPQL and writing a query for each method.

January 15 and January 16, 2022
This week at Skill Distillery we were introduced to JavaScript. While this project could have been accomplished by creating several html pages and moving between them, I wanted to force myself to learn JavaScript faster. I decided to create every page, field, and block of information dynamically with JavaScript. I learned how to create elements, append children to the document, and add event listeners to call different functions as needed. I learned a lot about JavaScript syntax and the importance of the browser development tools. I would use console.log() to check to make sure my objects were being moved correctly and how to read the errors in the console. I wish I had more time to include other features the backend Java has stubbed out, but next week we will be redoing the front end again with Angular and I plan to add more features and styling.
