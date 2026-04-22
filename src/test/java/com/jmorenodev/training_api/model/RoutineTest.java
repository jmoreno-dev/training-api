package com.jmorenodev.training_api.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RoutineTest {

    private Validator validator;
    private Routine validRoutine;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        User user = new User();

        validRoutine = new Routine(1L, "name", user);
    }

    @Test
    void shouldPassValidationWhenAllFieldsAreValid(){
        assertNotNull(validRoutine);

        Set<ConstraintViolation<Routine>> violations = validator.validate(validRoutine);

        assertTrue(violations.isEmpty());
    }

    @Test
    void shouldFailWhenNameIsLongerThanOneHundredCharacters(){
        validRoutine.setName(("a").repeat(101));

        Set<ConstraintViolation<Routine>> violations = validator.validate(validRoutine);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("name", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void shouldFailWhenNameIsBlank(){
        validRoutine.setName("");

        Set<ConstraintViolation<Routine>> violations = validator.validate(validRoutine);

        assertFalse(violations.isEmpty(), "La lista no viene vacía, se encontraron :" + violations);
        assertEquals(1, violations.size());
        assertEquals("name", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void shouldFailWhenNameIsNull(){
        validRoutine.setName(null);

        Set<ConstraintViolation<Routine>> violations = validator.validate(validRoutine);

        assertFalse(violations.isEmpty(), "La lista no viene vacía: "+violations);
        assertEquals(2, violations.size());
        assertEquals("name", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void shouldFailWhenUserIsNull(){
        validRoutine.setUser(null);

        Set<ConstraintViolation<Routine>> violations = validator.validate(validRoutine);

        assertFalse(violations.isEmpty(), "La lista no viene vacía: "+violations);
        assertEquals(1, violations.size());
        assertEquals("user", violations.iterator().next().getPropertyPath().toString());
    }
}