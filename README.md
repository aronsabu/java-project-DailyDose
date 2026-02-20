DailyDose – Medicine Management System

1. Project Title
DailyDose: A Desktop-Based Medicine Management System

2. Project Description
DailyDose is a Java-based desktop application developed using Java Swing for the graphical user interface and MySQL for database management. The application is designed to help users manage personal medicine records efficiently. It provides secure user authentication and allows users to add, update, view, and delete medicine details such as name, dosage, and timing.

The system ensures user-specific data storage, meaning each user can access and manage only their own medicine records. The application demonstrates the integration of GUI design, database connectivity using JDBC, and basic CRUD (Create, Read, Update, Delete) operations.

3. Objectives
To develop a user-friendly medicine management system.
To implement secure login and registration functionality.
To store and retrieve data using MySQL database.
To perform CRUD operations using JDBC connectivity.

To demonstrate practical implementation of Java Swing components.

4. Technologies Used
Java (Swing for GUI)
MySQL (Database)
JDBC (Database Connectivity)
VS Code / Any Java IDE
MySQL Connector/J

5. System Requirements
Java JDK 8 or higher
MySQL Server
MySQL Connector/J Driver
Any Java IDE or VS Code


7. Database Structure
Database Name: dailydose

Tables:

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

7. How to Run the Project

Install and start MySQL server.
Create the database and required tables.
Add MySQL Connector JAR to the project classpath.
Update database credentials in DBConnection.java.
Compile and run Main.java.

8. Conclusion
DailyDose is a simple and efficient medicine management application that demonstrates core Java programming concepts, GUI development, and database integration. It provides practical experience in developing a real-world desktop application.
