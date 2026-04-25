# 🏋️‍♂️ Training API

![Java 21](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=java)
![Spring Boot 3.5](https://img.shields.io/badge/Spring_Boot-3.5-brightgreen?style=flat-square&logo=spring)
![JUnit 5](https://img.shields.io/badge/JUnit-5-red?style=flat-square&logo=junit5)

REST API for the comprehensive management of strength training (Powerbuilding) and conditioning.

This project is designed from scratch, prioritizing the centralization of business logic and data shielding through rich domain models (avoiding the anemic domain model anti-pattern).

## 🛠️ Tech Stack

**Current Phase (Domain and Testing):**
* **Language:** Java 21
* **Framework:** Spring Boot 3.5.0
* **Validations:** Jakarta Validation
* **Testing:** JUnit 5 (Unit test isolation with `ValidatorFactory`)

**Upcoming Phases (Roadmap):**
* **Persistence:** PostgreSQL + Spring Data JPA + Flyway
* **Advanced Testing:** Mockito + Testcontainers
* **Infrastructure:** Docker, Docker Compose, GitHub Actions (CI/CD)
* **Cloud:** AWS (Deployment and operation)

## 🚦 Project Status: Work In Progress (Phase 1)

Currently, the project is in the **domain modeling** phase. The core of the application is built and secured.

* ✅ Implemented entities: `User`, `Exercise`, `Routine`, `Session`, `ExerciseSet`.
* ✅ **Zero-Trust Models:** Business rules protected directly within the entities using Jakarta Validation (`@NotBlank`, `@Size`, `@Positive`, etc.).
* ✅ Ultra-fast unit test coverage to guarantee data integrity without depending on the Spring context.

## 🚀 How to run locally

Since the project is focused strictly on the domain and testing layers at the moment, you do not need to spin up databases or containers to verify the logic.

1. Clone the repository:
```bash
git clone https://github.com/tu-usuario/training-api.git
cd training-api
```
