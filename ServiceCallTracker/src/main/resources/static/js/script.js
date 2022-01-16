window.addEventListener("load", function (e) {
  displayTodaysCalls();
  init();
});

function init() {
  todaysCallsBtn.addEventListener("click", function (e) {
    e.preventDefault();
    formField.textContent = "";
    customerResults.textContent = "";
    displayTodaysCalls();
  });

  activeCallsBtn.addEventListener("click", function (e) {
    e.preventDefault();
    formField.textContent = "";
    customerResults.textContent = "";
    displayActiveCalls();
  });

  searchCustomerBtn.addEventListener("click", function (e) {
    e.preventDefault();
    formField.textContent = "";
    customerResults.textContent = "";
    searchCustomerForm();
  });

  addCustomerBtn.addEventListener("click", function (e) {
    e.preventDefault();
    formField.textContent = "";
    customerResults.textContent = "";
    addCustomerForm();
  });
}

function displayTodaysCalls() {
  console.log("test display todays calls");
}

function displayActiveCalls() {
  console.log("test display active calls");
}

// this form populates when search customer is clicked
function searchCustomerForm() {
  //grab div from index.html
  let searchCustomer = document.getElementById("formField");

  //create the form
  let searchCustomerForm = document.createElement("form");
  searchCustomer.appendChild(searchCustomerForm);

  //create first name search box
  let searchFirstName = document.createElement("input");
  searchFirstName.name = "firstName";
  searchFirstName.type = "text";
  searchFirstName.placeholder = "First Name";
  searchCustomerForm.appendChild(searchFirstName);
  let br1 = document.createElement("br");
  searchCustomerForm.appendChild(br1);

  //create last name search box
  let searchLastName = document.createElement("input");
  searchLastName.name = "lastName";
  searchLastName.type = "text";
  searchLastName.placeholder = "Last Name";
  searchCustomerForm.appendChild(searchLastName);
  let br2 = document.createElement("br");
  searchCustomerForm.appendChild(br2);

  //form submit
  let searchCustomerSubmit = document.createElement("input");
  searchCustomerSubmit.id = "searchCustomerSubmit";
  searchCustomerSubmit.type = "submit";
  searchCustomerSubmit.value = "submit";
  searchCustomerForm.appendChild(searchCustomerSubmit);

  searchCustomerSubmit.addEventListener("click", function (e) {
    e.preventDefault();
    let fname = searchCustomerForm.firstName.value;
    let lname = searchCustomerForm.lastName.value;
    getCustomers(fname, lname);
  });
}

//checks info from search customer form and finds customer json
function getCustomers(fName, lName) {
  // grabs customers based on last name search
  if (fName.length === 0 && lName.length > 0) {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "api/customers/lastname/" + lName);
    xhr.onreadystatechange = function () {
      if (xhr.readyState === 4) {
        if (xhr.status === 200) {
          let customers = JSON.parse(xhr.responseText);
          console.log(customers);
          searchCustomerResults(customers);
        } else if (xhr.status === 404) {
          displayError("Customer not found!");
        }
      }
    };
    xhr.send();
  }
  //grabs customer based on first name search
  if (lName.length === 0 && fName.length > 0) {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "api/customers/firstname/" + fName);
    xhr.onreadystatechange = function () {
      if (xhr.readyState === 4) {
        if (xhr.status === 200) {
          var customers = JSON.parse(xhr.responseText);
          searchCustomerResults(customers);
        } else if (xhr.status === 404) {
          displayError("Customer not found!");
        }
      }
    };
    xhr.send();
  }
  //grabs customer on full name search
  if (fName.length > 0 && lName.length > 0) {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "api/customers/" + fName + "/" + lName);
    xhr.onreadystatechange = function () {
      if (xhr.readyState === 4) {
        if (xhr.status === 200) {
          var customers = JSON.parse(xhr.responseText);
          searchCustomerResults(customers);
        } else if (xhr.status === 404) {
          displayError("Customer not found!");
        }
      }
    };
    xhr.send();
  }
  //if search is left empty, all customers are grabbed
  if (fName.length === 0 && lName.length === 0) {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "api/customers");
    xhr.onreadystatechange = function () {
      if (xhr.readyState === 4) {
        if (xhr.status === 200) {
          var customers = JSON.parse(xhr.responseText);
          searchCustomerResults(customers);
        } else if (xhr.status === 404) {
          displayError("Customer not found!");
        }
      }
    };
    xhr.send();
  }
}

function searchCustomerResults(customers) {
  //grabs customer results div and clears last results
  let customerResults = document.getElementById("customerResults");
  customerResults.textContent = "";

  if (customers.length > 0) {
    let ul = document.createElement("ul");
    customerResults.appendChild(ul);

    // displays customer name, phone, and address
    for (let customer of customers) {
      //see addresses button
      let showCustomerAddr = document.createElement("button");
      showCustomerAddr.id = "showAddr";
      showCustomerAddr.textContent = "See Addresses";

      let customerDiv = document.createElement("div");
      ul.appendChild(customerDiv);
      let name = document.createElement("ul");
      let phone = document.createElement("li");
      let br = document.createElement("br");
      name.textContent = customer.firstName + " " + customer.lastName;
      phone.textContent = "Phone Number: " + customer.phoneNumber;
      customerDiv.appendChild(name);
      name.appendChild(phone);
      name.appendChild(showCustomerAddr);
      name.appendChild(br);

      // event listener for see address
      showCustomerAddr.addEventListener("click", function (e) {
        e.preventDefault();
        console.log("add address evntlsn");
        formField.textContent = "";
        customerResults.textContent = "";
        getAddresses(customer);
      });
    }
  }
}

function showCustomerAddresses(addresses) {
  //get the div from index.html
  let customerResults = document.getElementById("customerResults");
  customerResults.textContent = "";

  console.log(addresses);

  //address ul
  let custAddresses = document.createElement("ul");
  custAddresses.textContent =
    "Showing addresses for " + addresses[0].customer.firstName + " " + addresses[0].customer.lastName;
  customerResults.appendChild(custAddresses);

  //add address button
  let addAddress = document.createElement("button");
  addAddress.id = "addAddress";
  addAddress.textContent = "Add Address";
  custAddresses.appendChild(addAddress);
  let linebr = document.createElement("br");
  custAddresses.appendChild(linebr);

  // event listener for add address
  addAddress.addEventListener("click", function (e) {
    e.preventDefault();
    formField.textContent = "";
    customerResults.textContent =
      "New Address for " + addresses[0].customer.firstName + " " + addresses[0].customer.lastName;
    addAddressForm(addresses[0].customer);
  });

  //displays the addresses of customer
  for (let address of addresses) {
    let street = document.createElement("li");
    let city = document.createElement("li");
    let state = document.createElement("li");
    let br = document.createElement("br");

    street.textContent = address.address;
    city.textContent = address.city;
    state.textContent = address.stateAbbv;

    custAddresses.appendChild(street);
    custAddresses.appendChild(city);
    custAddresses.appendChild(state);

    // edit customer address/ add new address/ add service call buttons
    let editAddress = document.createElement("button");
    editAddress.id = "editAddress";
    editAddress.textContent = "Edit Address";
    custAddresses.appendChild(editAddress);
    //TODO ADD EVENT LISTENER FOR THIS BUTTON TAKES IN CUST ID AND CALLS ADD ADDRESS

    let addServiceCall = document.createElement("button");
    addServiceCall.id = "addServiceCall";
    addServiceCall.textContent = "New Service Call";
    custAddresses.appendChild(addServiceCall);
    //TODO ADD EVENT LISTENER FOR THIS BUTTON

    
    custAddresses.appendChild(br);
  }
}

function getAddresses(cust){
  var xhr = new XMLHttpRequest();
	xhr.open("GET", "api/address/customer/" + cust.id);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let addresses = JSON.parse(xhr.responseText);
				showCustomerAddresses(addresses)
			}
			else if (xhr.status === 404) {
				displayError("Address not found");
        addAddressForm(cust);
			}
		}
	}
	xhr.send();
}

function addCustomerForm() {
  //grab div from index.html
  let addCustomer = document.getElementById("formField");

  //create the form
  let addCustomerForm = document.createElement("form");
  addCustomerForm.textContent = "Customer Information";
  let linebreak = document.createElement("br");
  addCustomer.appendChild(addCustomerForm);
  addCustomerForm.appendChild(linebreak);

  //create first name add input
  let addFirstName = document.createElement("input");
  addFirstName.name = "firstName";
  addFirstName.type = "text";
  addFirstName.placeholder = "First Name";
  addCustomerForm.appendChild(addFirstName);
  let br1 = document.createElement("br");
  addCustomerForm.appendChild(br1);

  //create last name add input
  let addLastName = document.createElement("input");
  addLastName.name = "lastName";
  addLastName.type = "text";
  addLastName.placeholder = "Last Name";
  addCustomerForm.appendChild(addLastName);
  let br2 = document.createElement("br");
  addCustomerForm.appendChild(br2);

  //create phone number add input
  let addPhoneNumber = document.createElement("input");
  addPhoneNumber.name = "phoneNumber";
  addPhoneNumber.type = "text";
  addPhoneNumber.placeholder = "Phone Number";
  addCustomerForm.appendChild(addPhoneNumber);
  let br3 = document.createElement("br");
  addCustomerForm.appendChild(br3);

  //form submit
  let addCustomerSubmit = document.createElement("input");
  addCustomerSubmit.id = "addCustomerSubmit";
  addCustomerSubmit.type = "submit";
  addCustomerSubmit.value = "submit";
  addCustomerForm.appendChild(addCustomerSubmit);

  //submit creates customer, displays customer info, and populates address form
  addCustomerSubmit.addEventListener("click", function (e) {
    e.preventDefault();
    let fName = addCustomerForm.firstName.value;
    let lName = addCustomerForm.lastName.value;
    let phone = addCustomerForm.phoneNumber.value;
    if (
      fName.length < 2 ||
      typeof fName !== "string" ||
      lName.length < 2 ||
      typeof lName !== "string"
    ) {
      displayError("First and Last name must be 2 or more letters long");
    } else if (phone.length !== 10 || isNaN(phone)) {
      displayError(
        "Phone number must contain only 10 numbers, no spaces or special characters!"
      );
    } else {
      let customer = {
        firstName: fName,
        lastName: lName,
        phoneNumber: phone,
      };
      createCustomer(customer);
    }
  });
}

function createCustomer(newCustomer) {
  console.log(newCustomer);
  let xhr = new XMLHttpRequest();
  xhr.open("POST", "api/customers");
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      if (xhr.status === 200 || xhr.status === 201) {
        let customer = JSON.parse(xhr.responseText);
        let customerToPass = [customer];
        searchCustomerResults(customerToPass);
        console.log(newCustomer.id);
        addAddressForm(newCustomer.id);
      } else {
        console.error("Film create failmed with status: " + xhr.status);
      }
    }
  };
  xhr.setRequestHeader("Content-type", "application/json");
  xhr.send(JSON.stringify(newCustomer));
}

//takes in customer id to link the address to the correct customer
function addAddressForm(customer) {
  //grab div from index.html
  formField.textContent = "";
  let addAddress = document.getElementById("formField");

  //create the form
  let addAddressForm = document.createElement("form");
  addAddressForm.textContent = "Add New Address";
  let linebreak = document.createElement("br");
  addAddress.appendChild(addAddressForm);
  addAddressForm.appendChild(linebreak);

  //create street add input
  let addStreet = document.createElement("input");
  addStreet.name = "street";
  addStreet.type = "text";
  addStreet.placeholder = "Street";
  addAddressForm.appendChild(addStreet);
  let br1 = document.createElement("br");
  addAddressForm.appendChild(br1);

  //create city add input
  let addCity = document.createElement("input");
  addCity.name = "city";
  addCity.type = "text";
  addCity.placeholder = "City";
  addAddressForm.appendChild(addCity);
  let br2 = document.createElement("br");
  addAddressForm.appendChild(br2);

  //create state abbv add input
  let addState = document.createElement("input");
  addState.name = "state";
  addState.type = "text";
  addState.placeholder = "State Abbreviation";
  addAddressForm.appendChild(addState);
  let br3 = document.createElement("br");
  addAddressForm.appendChild(br3);

  //form submit
  let addAddressSubmit = document.createElement("input");
  addAddressSubmit.id = "addCustomerSubmit";
  addAddressSubmit.type = "submit";
  addAddressSubmit.value = "submit";
  addAddressForm.appendChild(addAddressSubmit);

  //submit creates address, displays customer info
  addAddressSubmit.addEventListener("click", function (e) {
    e.preventDefault();
    let street = addAddressForm.street.value;
    let city = addAddressForm.city.value;
    let state = addAddressForm.state.value;
    if (street.length < 2) {
      displayError("Please enter full street address");
    } else if (city.length < 2) {
      displayError("Please enter a valid city name");
    } else if (
      state.length < 2 ||
      state.length > 2 ||
      typeof state !== "string"
    ) {
      displayError("State abbreviation must be 2 letters");
    } else {
      let newAddress = {
        address: street,
        city: city,
        stateAbbv: state,
        customer: customer,
      };
      createAddress(newAddress, customer);
    }
  });
}

//recieves the address from the form and creates new address for selected customer
function createAddress(address, customer) {
  console.log(address);
  let xhr = new XMLHttpRequest();
  xhr.open("POST", "api/address");
  xhr.onreadystatechange = function () {
    if (xhr.status === 200 || xhr.status === 201) {
      let addr = JSON.parse(xhr.responseText);
      console.log(addr);
      let displayCust = [customer];
      searchCustomerResults(displayCust);
    } else {
      console.error("address failed to create with status" + xhr.status);
    }
  };
  xhr.setRequestHeader("Content-type", "application/json");
  xhr.send(JSON.stringify(address));
}

//displays error message
function displayError(msg) {
  let customerResults = document.getElementById("customerResults");
  customerResults.textContent = "";
  let message = document.createElement("p");
  message.textContent = msg;
  customerResults.appendChild(message);
}

//https://stackoverflow.com/questions/1531093/how-do-i-get-the-current-date-in-javascript

//Would we use status code 201 for PUT requests that were successful?
//201 usually only for POST.
// Would we do anything for put?
// 201 == Created, whereas PUT updates an existing resource, so 200 Ok for PUT is fine.
