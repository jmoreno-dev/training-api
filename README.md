# 🏋️‍♂️ Training API (Powerbuilding & Coaching)

![Java 21](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=openjdk)
![Spring Boot 4.0.5](https://img.shields.io/badge/Spring_Boot-4.0.5-brightgreen?style=flat-square&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=flat-square&logo=postgresql&logoColor=white)
![JUnit 5](https://img.shields.io/badge/JUnit-5-red?style=flat-square&logo=junit5)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=flat-square&logo=docker&logoColor=white)

A robust REST API for fitness coaching management.

Built by merging backend technical discipline with real-world sports physiotherapy and high-level powerbuilding expertise, this project models the true complexities of strength programming. It prioritizes **Domain-Driven Design (DDD)** concepts, ensuring business logic centralization and shielding against the anemic domain model anti-pattern.

## 🛠️ Tech Stack

* **Core:** Java 21 + Spring Boot 3.4
* **Security:** Spring Security + JWT authentication
* **Persistence:** Spring Data JPA + PostgreSQL + Flyway (Migrations)
* **Validations:** Jakarta Validation (Zero-Trust Models)
* **Testing:** JUnit 5 + Mockito
* **DevOps & Infra:** Docker, Docker Compose, GitHub Actions (CI/CD)
* **API Specs:** Swagger / OpenAPI

## 🧠 Domain Model & Architecture

### Entities
* `User` — Trainers and clients share a single table, differentiated by role (`ROLE_TRAINER` / `ROLE_CLIENT`). A client has a direct reference to their assigned trainer.
* `Exercise` — Shared catalogue available to all users. Features a name, optional description, and muscle group (`Muscles` enum).
* `Routine` — Created by a trainer and linked to a specific client.
* `RoutineExercise` — Links an exercise to a routine with prescribed targets: `targetReps`, `targetWeight`, `targetRpe`, and `targetRestSeconds`.
* `Session` — Logged by a client against a specific routine on a given date (validated as `@PastOrPresent`).
* `ExerciseSet` — Each individual set within a session. Records actual execution: reps, weight, RPE, and rest time.

### 💡 Design decisions worth noting
* **RPE (Rate of Perceived Exertion)** is modelled as an Enum in both `RoutineExercise` and `ExerciseSet`, explicitly distinguishing between the *prescribed target* and the *actual execution* — a distinction that reflects real-world strength programming.
* **Trainer-client relationship** is modelled as a self-referencing `@ManyToOne` on the `User` entity, keeping the schema clean without an extra join table.
* **Exercise catalogue** is shared across all users, consistent with how real fitness platforms and SaaS applications work.

## Database Schema

```mermaid
erDiagram
    USERS {
        long id PK
        varchar name
        varchar surname
        varchar email
        varchar password
        varchar role
        long trainer_id FK
    }
    ROUTINES {
        long id PK
        varchar name
        long user_id FK
    }
    EXERCISES {
        long id PK
        varchar name
        text description
        varchar muscle_group
    }
    ROUTINE_EXERCISES {
        long id PK
        double target_weight
        number target_reps
        varchar target_rpe
        number target_seconds
        long exercise_id FK
        long routine_id FK
    }
    SESSIONS {
        long id PK
        date date
        long user_id FK
        long routine_id FK
    }
    EXERCISE_SETS {
        long id PK
        number set_number
        double weight
        number reps
        varchar rpe
        number rest_seconds
        long exercise_id FK
        long session_id FK
    }
 
    USERS ||--o{ USERS : "trainer supervises client"
    USERS ||--o{ ROUTINES : "creates"
    USERS ||--o{ SESSIONS : "logs"
    ROUTINES ||--|{ ROUTINE_EXERCISES : "contains"
    EXERCISES ||--o{ ROUTINE_EXERCISES : "included in"
    SESSIONS ||--|{ EXERCISE_SETS : "includes"
    EXERCISES ||--o{ EXERCISE_SETS : "performed in"
    SESSIONS }o--|| ROUTINES : "based on"
```
## 🚦 Project Status (Vertical Slicing)

| Layer / Feature | Status |
| :--- | :---: |
| **Domain models + Jakarta validations** | ✅ Done |
| **Unit tests (model constraint coverage)** | ✅ Done |
| **Database schema design** | ✅ Done |
| Docker + PostgreSQL setup | ⏳ Pending |
| Flyway migrations | ⏳ Pending |
| Repository & Service layers | ⏳ Pending |
| REST controllers & Swagger | ⏳ Pending |
| JWT Authentication (Spring Security) | ⏳ Pending |
| CI/CD (GitHub Actions) | ⏳ Pending |

## 🚀 Getting Started

*Note: Full local setup requires Docker. Instructions will be updated as infrastructure layers are completed.*

1. Clone the repository:
```bash
git clone [https://github.com/jmoreno-dev/training-api.git](https://github.com/jmoreno-dev/training-api.git)
cd training-api
```

## Author

**Jose Antonio Moreno Marín**  
[LinkedIn](https://www.linkedin.com/in/joseantonio-morenomarin) · [josemorenodev.com](https://josemorenodev.com)