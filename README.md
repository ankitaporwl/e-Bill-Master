# e-Bill-Master

Electricity Billing System
This is a GUI made using Java Swing. It lets User perform multiple operations like:-

1- User can Create his Personal login for security purposes.

2- User can Add customers and Calculate their Electricity Bill.

3- User can Pay Electricity Bills.

4- User can Generate Bill.

About Project:
This Java application was created using Intelli J . Additional library was added for the support of JDBC (Required to setup the connection between the Database and Java Application). It contains 8 different classes which works together to create a better user experience .


->Login Screen class

->Main System class

->Add Customer class

->Pay Bill class

->Generate Bill class

->Show Details class

->Last Bill class

->Connection Setup class(JDBC - MySQL)

Database (MySQL)
Database for this Electricity Billing System contains 4 Tables

->Login Table (UserName,Password)

->Bill Table(MeterNumber,Units,Month,Amount)

->Emp Table(Name, MeterNumber, Address, State, City, Email, Phone)

->Tax Table(MeterLocation,MeterType,PhaseCode,BillType,Days,MeterRent,MCB_Rent,ServiceRent,GST)

Java communicates with MySQL tables using JDBC which stands for Java Database Connectivity.
![Screenshot 2024-08-05 012100](https://github.com/user-attachments/assets/c5f3428d-40c5-4c4a-ac70-f8a29faefde7)

login credentials- 
user name- Ankita , 
password - aaryan

Video- https://github.com/user-attachments/assets/63b5e128-bfbe-49a4-aaf0-ebaee8163a13


Database commands- 

create database ebs;
use ebs;
CREATE TABLE bill (
    meter_number INT NOT NULL PRIMARY KEY,
    units INT NOT NULL,
    month VARCHAR(20) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL
);

CREATE TABLE emp (
    name VARCHAR(100) NOT NULL,
    meter_number INT NOT NULL PRIMARY KEY,
    address VARCHAR(255) NOT NULL,
    state VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(15) NOT NULL
);

CREATE TABLE login (
    UserName VARCHAR(50) NOT NULL PRIMARY KEY,
    Password VARCHAR(50) NOT NULL
);


CREATE TABLE tax (
    meter_location VARCHAR(50) NOT NULL PRIMARY KEY,
    meter_type VARCHAR(50) NOT NULL,
    phase_code VARCHAR(10) NOT NULL,
    bill_type VARCHAR(50) NOT NULL,
    days INT NOT NULL,
    meter_rent DECIMAL(10, 2) NOT NULL,
    ncb_rent DECIMAL(10, 2) NOT NULL,
    service_rent DECIMAL(10, 2) NOT NULL,
    tax DECIMAL(5, 2) NOT NULL
);


INSERT INTO bill (meter_number, units, month, amount)
VALUES
(1, 120, 'January', 1500.50),
(2, 80, 'February', 1200.75);


INSERT INTO emp (name, meter_number, address, state, city, email, phone)
VALUES
('John Doe', 1, '123 Elm Street', 'California', 'Los Angeles', 'john@example.com', '1234567890'),
('Jane Smith', 2, '456 Maple Avenue', 'Texas', 'Dallas', 'jane@example.com', '9876543210');


INSERT INTO login (UserName, Password)
VALUES
('admin', 'password123'),
('user1', 'pass123');
insert into login values('Ankita','aaryan');

INSERT INTO tax (meter_location, meter_type, phase_code, bill_type, days, meter_rent, ncb_rent, service_rent, tax)
VALUES
('Downtown', 'Residential', '1PH', 'Standard', 30, 200.00, 50.00, 100.00, 5.00),
('Suburb', 'Commercial', '3PH', 'Premium', 30, 300.00, 80.00, 150.00, 7.50);




