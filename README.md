# 🏋️‍♂️ Training API

![Java 21](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=java)
![Spring Boot 4.0.5](https://img.shields.io/badge/Spring_Boot-4.0.5-brightgreen?style=flat-square&logo=spring)
![JUnit 5](https://img.shields.io/badge/JUnit-5-red?style=flat-square&logo=junit5)

REST API for the comprehensive management of strength training (Powerbuilding) and conditioning.

This project is designed from scratch, prioritizing the centralization of business logic and data shielding through rich domain models (avoiding the anemic domain model anti-pattern).

## 🛠️ Tech Stack

**Current Phase (Domain and Testing):**
* **Language:** Java 21
* **Framework:** Spring Boot 4.0.5
* **Validations:** Jakarta Validation
* **Testing:** JUnit 5 (Unit test isolation with `ValidatorFactory`)

**Upcoming Phases (Roadmap):**
* **Persistence:** PostgreSQL + Spring Data JPA + Flyway
* **Advanced Testing:** Mockito + Testcontainers
* **Infrastructure:** Docker, Docker Compose, GitHub Actions (CI/CD)
* **Cloud:** AWS (Deployment and operation)

## 🚦 Project Status: Work In Progress (Phase 1)

The project is currently in the **domain modeling and validation** phase.  
The application core is already built at entity level and protected with validation rules.

* ✅ Implemented entities: `User`, `Exercise`, `Routine`, `RoutineExercise`, `Session`, `ExerciseSet`.
* ✅ Domain relationships modeled with JPA annotations (`@ManyToOne`, `@JoinColumn`, `@Enumerated`, etc.).
* ✅ **Zero-Trust Models:** business rules protected directly inside entities using Jakarta Validation (`@NotBlank`, `@Size`, `@Positive`, `@PastOrPresent`, `@Pattern`, etc.).
* ✅ Unit tests focused on model constraints and domain integrity without depending on Spring context.

## 🧭 Next Steps (Roadmap)

1. **Persistence layer**
    - Repositories with Spring Data JPA
    - Database schema evolution with Flyway
    - PostgreSQL local setup

2. **Application layer**
    - Service layer with use-case driven methods
    - DTOs + mappers for input/output boundaries
    - Exception handling and consistent API error responses

3. **Web/API layer**
    - REST controllers for core flows (`users`, `routines`, `sessions`, `exercises`)
    - Request validation and response contracts
    - OpenAPI/Swagger documentation

4. **Testing improvements**
    - Service unit tests with Mockito
    - Integration tests (repository/API)
    - Testcontainers for real PostgreSQL-based tests

5. **DevOps and delivery**
    - Docker + Docker Compose for local environment
    - CI pipeline with GitHub Act

## 🚀 How to run locally

Since the project is focused strictly on the domain and testing layers at the moment, you do not need to spin up databases or containers to verify the logic.

1. Clone the repository:
```bash
git clone https://github.com/tu-usuario/training-api.git
cd training-api
```
