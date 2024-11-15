# Car Dashboard Project

## Overview

This Car Dashboard project is a web application that allows users to manage car details such as adding, updating, deleting, and displaying car information. It uses **JSP (Java Server Pages)**, **Servlets**, and **MySQL** for the backend, while the frontend is built with **HTML5**, **CSS3**, and **Bootstrap**. The application is designed to be easy to navigate and maintain.

## Features

- **Add Car Details**: Allows users to input and store new car information.
- **Update Car Details**: Enables users to modify existing car details by providing a car ID.
- **Delete Car Details**: Allows users to remove car records from the system using a car ID.
- **Display Car Details**: Lets users view car information by entering the car ID.

## Technologies Used

- **Frontend**:
  - HTML5
  - CSS3
  - Bootstrap 5.3.3
  - JavaScript (for form validation and interaction)
  
- **Backend**:
  - Java Servlets (for handling requests and performing CRUD operations)
  - JSP (for rendering dynamic content)
  - JDBC (for connecting to MySQL database)
  
- **Database**:
  - MySQL
  
- **Development Tools**:
  - Eclipse IDE
  - MySQL Workbench
  - Apache Tomcat (for running the Servlet application)

## Project Structure

```plaintext
ServletProject_CarDB
├── Deployment Descriptor: Archetype Created Web Application
├── Java Resources
│   ├── src/main/java
│   │   ├── com.jsp.servlet
│   │   │   ├── AddCarServlet.java
│   │   │   ├── DeleteCarServlet.java
│   │   │   ├── DisplayCarServlet.java
│   │   │   └── UpdateCarServlet.java
│   ├── src/main/resources
│   ├── src/test/java
│   ├── src/test/resources
├── Libraries
├── Deployed Resources
│   └── webapp
│       ├── WEB-INF
│       │   └── web.xml
│       ├── addCar.html
│       ├── deleteCar.html
│       ├── displayCar.html
│       ├── index.html
│       └── updateCar.html
├── web-resources
├── src
├── target
└── pom.xml
```

## File Descriptions

- **index.html**: The main page of the application with links to add, update, delete, or display car details.
- **addCar.html**: A form to add new car details (car brand, model, price).
- **updateCar.html**: A form to update existing car details based on car ID.
- **deleteCar.html**: A form to delete car details using car ID.
- **displayCar.html**: A form to display car details by providing a car ID.

### Backend Servlets

1. **AddCarServlet.java**: Handles the addition of a new car record to the database.
2. **UpdateCarServlet.java**: Handles the updating of an existing car record based on the provided car ID.
3. **DeleteCarServlet.java**: Handles the deletion of a car record based on the provided car ID.
4. **DisplayCarServlet.java**: Retrieves and displays car details based on the provided car ID.

### Configuration

- **web.xml**: The deployment descriptor file that maps URL patterns to specific servlets.

## How to Run the Project

### Prerequisites

1. Install **Java** (JDK 8 or higher).
2. Install **MySQL** and create a database named `servlet_cardb` with a table called `car` having the following columns:
    - `car_id` (INT, Primary Key)
    - `car_brand` (VARCHAR)
    - `car_model` (VARCHAR)
    - `car_price` (INT)
3. Set up **Apache Tomcat** for running the Servlets.
4. Make sure to update your **MySQL credentials** in the servlet code (`DisplayCarServlet.java` and other servlets).

### Steps to Run

1. Clone or download the project files.
2. Import the project into your favorite IDE (Eclipse/IntelliJ).
3. Configure your database credentials in the servlet files.
4. Deploy the project to Tomcat.
5. Access the project by opening a browser and navigating to the deployed app.

### Sample MySQL Database Schema

```sql
CREATE DATABASE servlet_cardb;

USE servlet_cardb;

CREATE TABLE car (
    car_id INT PRIMARY KEY,
    car_brand VARCHAR(100),
    car_model VARCHAR(100),
    car_price INT
);
