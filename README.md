Banking Management System

This is a backend Banking Management System built using Java, Spring Boot, MySQL, and REST APIs.

This project allows an Admin to manage users and allows users to perform banking operations like creating accounts, depositing money, withdrawing money, transferring funds, and viewing transaction history.

Features

User Management
Admin can create users
Users cannot self-register
Users can log in

Bank Account Management
Users can create bank accounts
Users can check account balance
Users can deposit money
Users can withdraw money
Users can transfer money to another account

Transaction Management
Users can view full transaction history

Technologies Used

Java
Spring Boot
Spring Data JPA
MySQL
Maven
REST API
Postman
Git and GitHub

API Operations (How Each Feature Works)
1. Create User (Admin Only)

Used to create a new user.

Request:
POST /api/users/create

Parameters:
username – the new user name
password – user password
role – USER or ADMIN

2. Login User

Used for logging in a user.

Request:
POST /api/users/login

Parameters:
username – user name
password – user password

3. Create Bank Account

Used to create a new bank account.

Request:
POST /api/accounts/create

Parameters:
ownerName – name of account holder
balance – initial balance

4. View Account Details

Used to fetch account details.

Request:
GET /api/accounts/{id}

Returns account id, owner name, and balance

5. Deposit Money

Used to add money to an account.

Request:
POST /api/accounts/deposit?id=&amount=

Parameters:
id – account id
amount – money to deposit

6. Withdraw Money

Used to remove money from an account.

Request:
POST /api/accounts/withdraw?id=&amount=

Parameters:
id – account id
amount – money to withdraw

7. Transfer Money

Used to transfer money between accounts.

Request:
POST /api/accounts/transfer?fromId=&toId=&amount=

Parameters:
fromId – sender account id
toId – receiver account id
amount – money to transfer

8. View Transaction History

Used to view all transactions for an account.

Request:
GET /api/transactions/{accountId}

Returns list of all transactions

API Testing

All APIs were tested using Postman.

Developer Details

Name: Sai Kaushik
GitHub: https://github.com/saikaushik7
