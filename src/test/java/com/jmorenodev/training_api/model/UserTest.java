package com.jmorenodev.training_api.model;

import com.jmorenodev.training_api.model.enums.Role;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private Validator validator;
    private User validUser;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        validUser = new User(1L, "Arnold", "Schwarzenegger", "arnold@goldengym.com", "securePass123", Role.ROLE_CLIENT, null);
    }
    @Test
    void shouldPassValidationWhenUserIsValid() {
        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertTrue(violations.isEmpty(), "Usuario sin errores");
    }

    @Test
    void shouldFailWhenEmailIsInvalid(){
        validUser.setEmail("email-without-format");

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("email", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void shouldFailWhenNameIsTooShort() {
        validUser.setName("A");

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertFalse(violations.isEmpty());
        assertEquals("name", violations.iterator().next().getPropertyPath().toString());
    }


}
