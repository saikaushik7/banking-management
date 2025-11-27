Banking Management System

This is a backend Banking Management System built using Java, Spring Boot, MySQL, and REST APIs.
The project supports admin-controlled user management and provides core banking operations such as account creation, deposit, withdrawal, fund transfer, and transaction history tracking.

Features
User Management

Admin can create users

Users cannot self-register

Users can log in securely

Bank Account Management

Create bank accounts

Check account balance

Deposit money

Withdraw money

Transfer money between accounts

Transaction Management

View complete transaction history for accounts

Technologies Used

Java 17

Spring Boot

Spring Data JPA

MySQL

Maven

REST API

Postman

Git and GitHub

API Operations
1. Create User (Admin Only)

Endpoint
POST /api/users/create

Parameters

username – name of the new user

password – user password

role – USER or ADMIN

2. Login User

Endpoint
POST /api/users/login

Parameters

username – user name

password – user password

3. Create Bank Account

Endpoint
POST /api/accounts/create

Parameters

ownerName – account holder name

balance – initial balance

4. View Account Details

Endpoint
GET /api/accounts/{id}

Returns

Account ID

Owner name

Account balance

5. Deposit Money

Endpoint
POST /api/accounts/deposit?id=&amount=

Parameters

id – account ID

amount – money to deposit

6. Withdraw Money

Endpoint
POST /api/accounts/withdraw?id=&amount=

Parameters

id – account ID

amount – money to withdraw

7. Transfer Money

Endpoint
POST /api/accounts/transfer?fromId=&toId=&amount=

Parameters

fromId – sender account ID

toId – receiver account ID

amount – amount to transfer

8. View Transaction History

Endpoint
GET /api/transactions/{accountId}

Returns

List of all transactions for the account

Project Structure

controller – Handles API requests

service – Business logic layer

repository – Database layer

entity – Database entity classes

API Testing

All APIs were tested using Postman.

Future Improvements

Add JWT based authentication

Add role-based authorization

Add pagination for transaction history

Add frontend using Angular or React

Developer

Name: Sai Kaushik
GitHub: https://github.com/saikaushik7
