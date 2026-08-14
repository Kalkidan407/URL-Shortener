
# 🔗 URL Shortener API

A RESTful URL Shortener API built with Java and Spring Boot. The project focuses on clean backend architecture, database management, API design, testing, and containerized deployment.

## 🚀 Features

- Create short URLs
- Redirect using a short code
- Track click counts
- Detect and handle duplicate URLs
- Return an existing short code when a URL already exists
- Store website/site information
- URL expiration support
- Soft deletion
- Global exception handling
- DTO-based API design
- Database migrations with Flyway
- Integration testing
- Swagger/OpenAPI documentation
- Dockerized Spring Boot application and PostgreSQL database
- Runs the application container as a non-root user

## 🛠️ Tech Stack

- **Java 21**
- **Spring Boot**
- **Spring Data JPA / Hibernate**
- **PostgreSQL**
- **Flyway**
- **MapStruct**
- **Lombok**
- **Maven**
- **Docker & Docker Compose**
- **Swagger / OpenAPI**
- **JUnit**

## 🏗️ Architecture

The application follows a layered architecture:

```text
Client
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
PostgreSQL
````

DTOs are used as the API boundary instead of exposing JPA entities directly.

```text
Request
   ↓
Request DTO
   ↓
Controller
   ↓
Service
   ↓
Entity
   ↓
Repository
   ↓
Database
```

Responses are mapped from entities to response DTOs using MapStruct.

## 💡 Key Design Decisions

### Duplicate URL Handling

When a user submits a URL that already exists, the API doesn't create another short code.

Instead, it returns the existing short code and indicates that the URL already exists.

```json
{
  "shortCode": "GYmdGP",
  "exists": true,
  "message": "URL already exists. Returning existing short code."
}
```

This avoids unnecessary duplicate records while giving the API consumer clear feedback.

### DTOs

The API uses DTOs to separate the API contract from the persistence model.

A DTO doesn't have to contain exactly the same fields as an Entity. For example, fields such as `exists` and `message` are useful for the API response but don't need to be stored in the database.

### Database Migrations

Flyway manages database schema changes through versioned migration files:

```text
V1__create_urls_table.sql
V2__add_site_name.sql
```

This makes database changes reproducible across environments.

### Container Security

The Spring Boot application runs as a dedicated non-root user inside its Docker container instead of running the application as root.

## 📚 API Documentation

Swagger UI is available when the application is running:

```text
http://localhost:8080/swagger-ui/index.html
```

Swagger provides an interactive interface for exploring and testing the API endpoints.

## 🧪 Testing

The project includes integration tests that verify the application together with the database and Spring application context.

Run the tests with:

```bash
mvn test
```

## 🐳 Running with Docker

### Prerequisites

* Java 21
* Maven
* Docker
* Docker Compose

### Build the application

```bash
mvn clean package
```

### Start the application

```bash
sudo docker compose up --build -d
```

### Check containers

```bash
sudo docker ps
```

### View logs

```bash
sudo docker compose logs -f
```

The API will be available at:

```text
http://localhost:8080
```

## 🗄️ Database

The application uses PostgreSQL for persistent storage.

Flyway automatically applies database migrations when the application starts, keeping the database schema versioned and consistent across environments.

## 📁 Project Structure

```text
src/
├── main/
│   ├── java/com/urlshrtner/project/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   │   ├── entity/
│   │   ├── dto/
│   │   ├── mapper/
│   │   └── exception/
│   │
│   └── resources/
│       └── db/migration/
│
└── test/
    └── java/com/urlshrtner/project/
```

## 🔮 Future Improvements

* Authentication and authorization
* Rate limiting
* URL analytics
* Pagination and filtering
* Caching
* Custom short-code support
* CI/CD pipeline

## 👨‍💻 Author

**Kalkidan Kelemework**

Computer Science student and aspiring backend developer focused on Java, Spring Boot, REST APIs, and backend system design.

```

