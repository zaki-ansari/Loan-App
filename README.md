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
