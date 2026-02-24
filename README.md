DailyDose – Medicine Management System


Team Members
Alan Shaji – 24UBC106
Aron Sabu Abraham – 24UBC117


Problem Statement

Managing daily medicines manually can lead to confusion, missed doses, and lack of proper organization. There is a need for a simple desktop-based system that allows users to securely store, manage, and track their personal medicine details in an organized and user-specific manner.


Objective

The objective of this project is to develop a desktop application that:
Provides secure user registration and login functionality.
Allows users to add, edit, and delete medicine records.
Stores medicine details such as name, dosage, and timing.
Maintains user-specific data using database connectivity.
Implements a reminder system based on system time.
Demonstrates the integration of GUI development and database management using Java.


Features

User Registration (Sign Up)
Secure Login Authentication
Add Medicine Records
Edit Existing Medicines
Delete Medicines
View Medicine Details
Time-Based Reminder Notification System
Reminder System


The application includes a time-based reminder feature. Users can set a reminder time while adding a medicine. The system continuously checks the computer’s system time using a timer mechanism. When the current system time matches the stored reminder time in the database, a notification popup and sound alert are generated to remind the user to take the medicine.



This functionality is implemented using:

javax.swing.Timer
LocalTime (Java Time API)
Database time comparison using JDBC


Technologies Used

Programming Language: Java
GUI Framework: Java Swing
Database: MySQL
Connectivity: JDBC
IDE/Editor: VS Code
Driver: MySQL Connector/J



Database Structure
Database Name: dailydose

Tables
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
reminder_time (TIME datatype)


Steps to Run the Program

Install and start MySQL Server.
Create the database dailydose.
Create the required tables (users and medicines).
Download MySQL Connector/J and add the JAR file to the project classpath.
Update the database username and password in DBConnection.java.
Compile all Java files.

Run Main.java to start the application.



Sample Inputs and Outputs / Test Cases


Test Case 1 – User Registration (Valid Input)

Input:
Name: Alan
Email: alanshaji@gmail.com
Password: alan@123

Action:
Click on Register button.

Expected Output:
Message displayed: "User Registered!"



Test Case 2 – Successful Login

Input:
Email: alanshaji@gmail.com
Password: alan@123

Action:
Click on Login button.

Expected Output:
Open HomePage



Test Case 3 – Add Medicine

Input:
Medicine Name: Paracetamol
Dosage: 500mg
Timing: Morning
Reminder Time: 08:30

Action:
Click on Add Medicine button.

Expected Output:
Message: "Medicine Added!"
Medicine details displayed on Home Page.



Test Case 4 – Delete Medicine

Input:
Medicine Name: Paracetamol

Action:
Click on Remove Medicine button.

Expected Output:
Message: "Medicine Removed!"
Medicine no longer appears on Home Page.



Test Case 5 – Reminder Notification

Input:
Reminder Time set to current system time (HH:MM).

Action:
System time matches stored reminder time.

Expected Output:
Popup notification appears.
