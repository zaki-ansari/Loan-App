## Loan-App
## ER Diagram for the application

![Capture](https://user-images.githubusercontent.com/99637633/196092043-a1675f40-9e0f-4ae9-9d11-1242d0470044.PNG)


## Tech Stack

* Java
* Angular
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL

## Modules

* Loan Module
* PaymentSchedule Module


## Features

* In Loan-App, we can create a loan by filling the details in the create loan page
* All the loans will be displayed in all loans page
* For each particular loan, payment schedules will be displayed

## Installation & Run

* Before running the API server, you should update the database config inside the application.properties file. 
* Update the port number, username and password as per your local database config.

```
    server.port=8080

    spring.datasource.url=jdbc:mysql://localhost:3306/loan_app
    spring.datasource.username=root
    spring.datasource.password=root

```

## API Root Endpoint

`https://localhost:8080/`


## API Module Endpoints

### Loan Module

* `POST /loan/save` : creating a new loan
* `GET /loan/all` : get all loan for a customer

### PaymentSchedule Module

* `GET /paymentSchedule/{Id}` : creating a new loan
* `POST /paymentSchedule/updatestatus` : update particular paymentschedule status to paid status
* `POST /paymentSchedule/updatestatustoawaiting` : update particular paymentschedule status to awaitingpayment status

### Sample API Response for Customer Login

`POST   localhost:8009/login/customer`

* Request Body

```
   {
    
    "loanAmount":10000,
    "paymentTerm":"Even Principal",
    "loanTerm":1,
    "paymentFrequency":"QUARTERLY",
    "interestRate":10


}
```

* Response

```
  {
    "customerId": 39,
    "loanAmount": 10000,
    "tradeDate": "2022-10-17",
    "loanStartDate": "2022-10-27",
    "maturityDate": "2023-10-17",
    "paymentFrequency": 3,
    "interestRate": 10.0,
    "paymentSchedule": [
        {
            "paymentScheduleId": 40,
            "paymentDate": "2023-01-27",
            "principal": 10000,
            "projectedInterest": 250.0,
            "paymentStatus": "PROJECTED",
            "paymentAmount": 2750.0
        },
        {
            "paymentScheduleId": 41,
            "paymentDate": "2023-04-27",
            "principal": 7500,
            "projectedInterest": 188.0,
            "paymentStatus": "PROJECTED",
            "paymentAmount": 2688.0
        },
        {
            "paymentScheduleId": 42,
            "paymentDate": "2023-07-27",
            "principal": 5000,
            "projectedInterest": 125.0,
            "paymentStatus": "PROJECTED",
            "paymentAmount": 2625.0
        },
        {
            "paymentScheduleId": 43,
            "paymentDate": "2023-10-27",
            "principal": 2500,
            "projectedInterest": 63.0,
            "paymentStatus": "PROJECTED",
            "paymentAmount": 2563.0
        }
    ]
}
```

## Frondend-UI
# GetStartPage
![GetStartPage](https://user-images.githubusercontent.com/99637633/196093747-6880ae20-82a0-4576-a6a4-83f3a3da639c.PNG)
* click on getstart button to navigate to home page

# HomePage
![HomePage](https://user-images.githubusercontent.com/99637633/196093902-b30b9d1a-0d6e-49ba-853e-9b293216c295.PNG)
* click on createloan button to navigate to createloan page
* click on all loan button to navigate to all loan page
* click on Loan-App on header to navigate to home page

# CreateLoanPage
![CreateLoanPage](https://user-images.githubusercontent.com/99637633/196094084-4e7eb800-fb95-4066-9799-04eaf0f1d873.PNG)
* create a loan by filling the details in the form by giving proper details

#AllLoanPage
![AllLoansPage](https://user-images.githubusercontent.com/99637633/196094193-5ade94a8-369b-49af-8024-c521fc7a5a3f.PNG)
* all loans are displayed here in all loan page
* click on particular loan to navigate to payment schedule display page

#PaymentSchedulePage
![PaymentSchedulePage](https://user-images.githubusercontent.com/99637633/196094384-750c3e9f-c61e-42c1-9d01-71fad4fb61bc.PNG)
* If the maturity date is arrived then the status will be change to awaitingpayment
* On the maturity date, we can pay the amount and status will be change to paid
* If you click on pay button before maturity date, a alert message will be displayed



