# Group Management Application

This is a Spring Boot application designed to manage Users, Teams, and their associations. It provides a RESTful API to create users and teams, assign users to teams with specific roles, and retrieve these details.

## Technologies Used

* **Java**: 21
* **Framework**: Spring Boot 3.x
* **Data Access**: Spring Data JPA
* **Database**: PostgreSQL
* **Other Tools**: Lombok (for boilerplate code reduction), Validation (for request validation)

## Project Structure

The project follows a standard layered architecture for Spring Boot applications:

```text
src/main/java/com/nikhil/group/
├── controller/       # REST API endpoints (TeamController, UserController, TeamUserController)
├── dto/              # Data Transfer Objects
│   ├── request/      # DTOs for incoming HTTP requests (e.g., CreateUserRequest, AddUserToTeamRequest)
│   └── response/     # DTOs for outgoing HTTP responses (e.g., UserResponse, TeamUserResponse)
├── entity/           # JPA Entities representing database tables (Team, User, TeamUser)
├── enums/            # Enumerations used within the domain (e.g., TeamRole)
├── repository/       # Spring Data JPA repositories for database interactions
├── service/          # Business logic layer
└── GroupApplication.java # Main application runner class
```

### Key Directories Explained

* **`controller/`**: Handles incoming HTTP requests, validates them, passes them to the service layer, and returns the appropriate HTTP responses.
* **`dto/`**: Ensures that the internal database entities (`entity/`) are not directly exposed to the outside world, providing a clear contract for the API.
* **`entity/`**: Defines the data model. `Team` and `User` are independent entities, while `TeamUser` acts as a join table entity that also stores the `TeamRole` for a specific user in a specific team.
* **`service/`**: Contains the core business logic, orchestrating calls to the database via repositories and applying business rules.

## REST API Endpoints

### Users (`/users`)
* `POST /users`: Create a new user.
* `GET /users/{userId}`: Retrieve a user by their ID.
* `PATCH /users/{userId}`: Update a user's details.

### Teams (`/team`)
* `POST /team`: Create a new team.
* `GET /team/{teamId}`: Retrieve a team by its ID.

### Team Members (`/teams/{teamId}/users`)
* `POST /teams/{teamId}/users`: Add a user to a team with a specific role.
* `GET /teams/{teamId}/users`: Get a list of all users in a specific team.
* `PATCH /teams/{teamId}/users/users/{userId}`: Update the role of a user within a team.

## Getting Started

### Prerequisites

* Java 21
* Maven
* PostgreSQL database

### Configuration

The application uses PostgreSQL. Database connection details are configured in `src/main/resources/application-local.properties`.

Ensure you have a PostgreSQL instance running and update the credentials if necessary:
```properties
spring.datasource.url=jdbc:postgresql://<host>:<port>/<db_name>
spring.datasource.username=<username>
spring.datasource.password=<password>
```

### Running the Application

You can run the application using Maven wrapper:

```bash
./mvnw spring-boot:run
```

Alternatively, you can build the JAR file and run it:

```bash
./mvnw clean package
java -jar target/group-0.0.1-SNAPSHOT.jar
```
