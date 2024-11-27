# Employee Management System

A simple CRUD (Create, Read, Update, Delete) application built using Spring Boot to manage employee information.

---

## Features

- Add new employees
- View employee details
- Update existing employee information
- Delete employees
- View all employees

---

## Technologies Used

- **Backend:** Spring Boot
- **Database:** H2 (In-Memory Database)
- **Build Tool:** Maven
- **Language:** Java

---

## Prerequisites

- Java 17 or above
- Maven 3.8+
- IDE with Spring Boot support (e.g., IntelliJ IDEA, Eclipse)
- Postman or any REST client (optional, for API testing)

---

## Getting Started

### Clone the Repository
```bash
git clone https://github.com/jayitasaha40/Employee-Management-System.git
cd Employee-Management-System

---

## API Endpoints

| Method | Endpoint           | Description                     |
|--------|--------------------|---------------------------------|
| POST   | `/employees`       | Add a new employee             |
| GET    | `/employees`       | Get all employees              |
| GET    | `/employees/{id}`  | Get employee by ID             |
| PUT    | `/employees/{id}`  | Update an existing employee    |
| DELETE | `/employees/{id}`  | Delete an employee             |

### Sample JSON Payloads

#### Add New Employee (POST `/employees`)
```json
{
  "name": "John Doe",
  "email": "johndoe@example.com",
  "department": "Engineering",
  "salary": 75000
}
