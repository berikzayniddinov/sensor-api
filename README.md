# Sensor API

Sensor API is a RESTful service built with Spring Boot for managing sensors and their measurements. It includes secure authentication using JWT and comprehensive API documentation through Swagger.

## Features
- Add, retrieve, and delete sensors.
- Add and retrieve measurements.
- Secure API endpoints with JWT-based authentication.
- Swagger UI for API exploration and testing.

---

## Build and Run with Docker

### Prerequisites
- Docker version 20.10 or higher.
- Docker Compose version 1.29 or higher.

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/berikzayniddinov/sensor-api.git
   cd sensor-api
   ```

2. Build Docker containers:
   ```bash
   docker-compose build
   ```

3. Start the application:
   ```bash
   docker-compose up
   ```

4. Access the API:
   - API Base URL: [http://localhost:8080](http://localhost:8080)
   - Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## API Usage

### Add a Sensor
- **Endpoint:** `POST /api/sensors`
- **Request:**
  ```json
  {
    "name": "Temperature Sensor",
    "model": "TS-1000"
  }
  ```
- **Response:**
  ```json
  {
    "id": 1,
    "name": "Temperature Sensor",
    "model": "TS-1000"
  }
  ```

### Get All Sensors
- **Endpoint:** `GET /api/sensors`
- **Response:**
  ```json
  [
    {
      "id": 1,
      "name": "Temperature Sensor",
      "model": "TS-1000"
    }
  ]
  ```

### Add a Measurement
- **Endpoint:** `POST /api/measurements`
- **Request:**
  ```json
  {
    "value": 23.5,
    "raining": false,
    "sensorId": 1
  }
  ```
- **Response:**
  ```json
  {
    "id": 1,
    "value": 23.5,
    "raining": false,
    "sensorId": 1
  }
  ```

### Get All Measurements
- **Endpoint:** `GET /api/measurements`
- **Response:**
  ```json
  [
    {
      "id": 1,
      "value": 23.5,
      "raining": false,
      "sensorId": 1
    }
  ]
  ```

---

## Technologies Used
- **Java 17**
- **Spring Boot 3.1**
- **PostgreSQL**
- **Hibernate**
- **Swagger/OpenAPI**
- **Docker/Docker Compose**

---

## Contributing
Contributions are welcome! Feel free to fork the repository and create a pull request with your improvements.

---

## Contact
- **Author:** Berik Zayniddinov
- **GitHub:** [berikzayniddinov](https://github.com/berikzayniddinov)
```

This single-file README contains all sections: project description, Docker setup, API usage examples, technologies used, and contribution guidelines. Let me know if you need further refinements!
