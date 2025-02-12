# Reservation Service

## Overview
The **Reservation Service** is a microservice within the Movie Reservation System responsible for managing movie reservations. It handles reservation creation, retrieval, and association with users, tickets, and seats.

## Features
- Create reservations for users upon successful ticket booking.
- Retrieve reservation details by user.
- Associate reservations with tickets and seat selections.

## Technologies Used
- **Spring Boot** – Core framework for building the microservice.
- **Spring Data JPA** – For interacting with the database.
- **MySQL** – Database for storing reservation-related information.
- **Feign Client** – For inter-service communication.
- **Spring Cloud Eureka** – Service discovery and registration.
- **JWT Authentication** – Securing API endpoints.

## API Endpoints

### Reservation Management
| Method | Endpoint | Description |
|--------|---------|-------------|
| `GET` | `/reservations/{userId}` | Retrieve reservation details by user ID |
| `POST` | `/reservations/book` | Create a new reservation |
| `POST` | `/reservations/cancel` | Cancel reservation |

## Service Communication
- Communicates with **User Service** to fetch user details.
- Communicates with **Ticket Service** to associate reservations with tickets.
- Communicates with **Seat Service** to validate seat selection.
- Communicates with **Schedule Service** to associate reservations with schedules.

## Installation & Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/ChristosDurro/movie-reservation-system-reservation-service.git
   ```
2. Navigate to the project folder:
   ```bash
   cd movie-reservation-system-reservation-service
   ```
3. Configure the `application.properties` file:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/reservation_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password

   # Eureka and other configurations you might want
   ```
4. Build and run the service:
   ```bash
   mvn spring-boot:run
   ```

---

This service is part of the **Movie Reservation System**, designed to showcase a microservices-based architecture with Spring Boot.

