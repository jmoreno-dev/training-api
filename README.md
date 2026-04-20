# 🏋️‍♂️ Training API

![Java 21](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=java)
![Spring Boot 3.5](https://img.shields.io/badge/Spring_Boot-3.5-brightgreen?style=flat-square&logo=spring)
![JUnit 5](https://img.shields.io/badge/JUnit-5-red?style=flat-square&logo=junit5)

API REST para la gestión integral de entrenamiento de fuerza (Powerbuilding) y acondicionamiento.

Este proyecto está diseñado desde cero, priorizando la centralización de la lógica de negocio y el blindaje de los datos mediante modelos ricos (evitando el antipatrón de modelos anémicos).

## 🛠️ Stack Tecnológico

**Fase Actual (Dominio y Testing):**
* **Lenguaje:** Java 21
* **Framework:** Spring Boot 3.5.0
* **Validaciones:** Jakarta Validation
* **Testing:** JUnit 5 (Aislamiento de tests unitarios con `ValidatorFactory`)

**Próximas Fases (En Roadmap):**
* **Persistencia:** PostgreSQL + Spring Data JPA + Flyway
* **Testing Avanzado:** Mockito + Testcontainers
* **Infraestructura:** Docker, Docker Compose, GitHub Actions (CI/CD)
* **Cloud:** AWS (Despliegue y operación)

## 🚦 Estado del Proyecto: Work In Progress (Fase 1)

Actualmente, el proyecto se encuentra en la fase de **modelado de dominio**. El núcleo de la aplicación está construido y protegido.

* ✅ Entidades implementadas: `User`, `Exercise`, `Routine`, `Session`, `ExerciseSet`.
* ✅ **Zero-Trust Models:** Reglas de negocio protegidas directamente en las entidades mediante Jakarta Validation (`@NotBlank`, `@Size`, `@Positive`, etc.).
* ✅ Cobertura de tests unitarios ultrarrápidos para garantizar la integridad de los datos sin depender del contexto de Spring.

## 🚀 Cómo ejecutar en local

Puesto que el proyecto está enfocado actualmente en la capa de dominio y testing, no necesitas levantar bases de datos ni contenedores para comprobar la lógica.

1. Clona el repositorio:
```bash
git clone [https://github.com/tu-usuario/training-api.git](https://github.com/tu-usuario/training-api.git)
cd training-api