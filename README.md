# Land Ownership Tracking Management System

Spring Boot backend for Rwanda Land Management and Use Authority (RLMUA) to track land ownership history across owners and parcels.

## Features
- Admin signup/login with JWT authentication.
- Protected APIs for owner, land parcel, and land title registration.
- Ownership history through land titles linked to owners and parcels.
- Pagination on list endpoints.
- Swagger UI API documentation.
- Global exception handling and bean validation.
- CORS and stateless Spring Security configuration.
- Structured logging.

## Tech Stack
- Java 17
- Spring Boot 3
- Spring Security + JWT
- Spring Data JPA
- PostgreSQL
- springdoc OpenAPI (Swagger UI)

## API Overview
### Auth (public)
- `POST /api/auth/signup`
- `POST /api/auth/login`

### Protected (ADMIN role)
- `POST /api/owners`, `GET /api/owners`
- `POST /api/parcels`, `GET /api/parcels`
- `POST /api/titles`, `GET /api/titles`

All GET endpoints support pagination via query params, e.g. `?page=0&size=10`.

## Run Locally
1. Create PostgreSQL database:
   - DB: `land_tracking`
   - User: `postgres`
   - Password: `postgres`
2. Update `src/main/resources/application.properties` if needed.
3. Start app:
   ```bash
   mvn spring-boot:run
   ```

## Swagger
- UI: `http://localhost:8080/swagger-ui/index.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

## Example Data
Land parcel fields:
- Plot Number (e.g. KG 123)
- Land Size (e.g. 850 sqm)
- Land Location (e.g. Gasabo)
- Land Use Type (RESIDENTIAL, COMMERCIAL, INDUSTRIAL, AGRICULTURAL, MIXED_USE)
- Registration Date (e.g. 2010-01-01)

Owner fields:
- Owner Names
- National ID
- Phone Number
- Address

Land title fields:
- Owner
- Land Parcel
- Title Number
- Issue Date
