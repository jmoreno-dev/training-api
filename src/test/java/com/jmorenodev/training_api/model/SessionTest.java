package com.jmorenodev.training_api.model;

import com.jmorenodev.training_api.model.enums.Role;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SessionTest {
    private Validator validator;
    private Session validSession;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        User user = new User(1L, "name", "surname", "email@email.com", "12345678", Role.CLIENT, null);
        Routine routine = new Routine(1L, "Heavy leg day", user);

        validSession = new Session(1L, LocalDate.now(), user, routine);
    }

    @Test
    void shouldPassValidationWhenAllFieldsAreValid(){
        assertNotNull(validSession);

        Set<ConstraintViolation<Session>> violations = validator.validate(validSession);

        assertTrue(violations.isEmpty());
    }

    @Test
    void shouldFailIfSetFutureDate(){
        validSession.setDate(LocalDate.of(2300, 4, 3));

        Set<ConstraintViolation<Session>> violations = validator.validate(validSession);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("date", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void shouldPassIfSetPastDate(){
        validSession.setDate(LocalDate.of(1300, 4, 3));

        Set<ConstraintViolation<Session>> violations = validator.validate(validSession);

        assertTrue(violations.isEmpty());
    }

    @Test
    void shouldPassIfSetPresentDate(){
        validSession.setDate(LocalDate.now());

        Set<ConstraintViolation<Session>> violations = validator.validate(validSession);

        assertTrue(violations.isEmpty());
    }

    @Test
    void shouldFailWhenDateIsNull(){
        validSession.setDate(null);

        Set<ConstraintViolation<Session>> violations = validator.validate(validSession);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("date", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void shouldFailWhenUserIsNull(){
        validSession.setUser(null);

        Set<ConstraintViolation<Session>> violations = validator.validate(validSession);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("user", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void shouldFailWhenRoutineIsNull(){
        validSession.setRoutine(null);

        Set<ConstraintViolation<Session>> violations = validator.validate(validSession);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("routine", violations.iterator().next().getPropertyPath().toString());
    }
}