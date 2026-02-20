DailyDose – Medicine Management System

1. Team Members:-
Alan Shaji 24UBC106
Aron Sabu Abraham 24UBC117


2. Problem Statement

Managing daily medicines manually can lead to confusion, missed entries, and lack of organization. There is a need for a simple desktop-based system that allows users to securely store and manage their personal medicine details in an organized and user-specific manner.


3. Objective

The objective of this project is to develop a desktop application that:
Provides secure user registration and login.
Allows users to add, edit, and delete medicine records.
Stores medicine details such as name, dosage, and timing.
Maintains user-specific data using database connectivity.
Demonstrates the integration of GUI development and database management using Java.


4. Features

User Registration (Sign Up)
Secure Login Authentication
Add Medicine Records
Edit Existing Medicines
Delete Medicines
View Medicine Details



5. Technologies Used:-

Programming Language: Java
GUI Framework: Java Swing
Database: MySQL
Connectivity: JDBC
IDE/Editor: VS Code
Driver: MySQL Connector/J

Database Structure
Database Name: dailydose

*Tables:
users
id (Primary Key)
name
email (Unique)
password

medicines
id (Primary Key)
user_id (Foreign Key)
name
dosage
timing


6. Steps to Run the Program

Install and start MySQL Server.
Create the database dailydose.
Create the required tables (users and medicines).
Download MySQL Connector/J and add the JAR file to the project classpath.
Update the database username and password in DBConnection.java.

Compile all Java files.
Run Main.java to start the application.
