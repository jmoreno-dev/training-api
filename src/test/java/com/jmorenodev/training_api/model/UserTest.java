package com.jmorenodev.training_api.model;

import com.jmorenodev.training_api.model.enums.Role;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private Validator validator;
    private User validUser;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        validUser = new User(1L, "Arnold", "Schwarzenegger", "arnold@goldsgym.com", "securePass123", Role.CLIENT, null);
    }

    @Test
    void shouldPassValidationWhenAllFieldsAreValid() {
        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertTrue(violations.isEmpty(), "Usuario sin errores");
    }

    @Test
    void shouldFailWhenNameIsBlank(){
        validUser.setName("");

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertFalse(violations.isEmpty());
        assertEquals(2, violations.size());
        for (ConstraintViolation<User> violation : violations) {
            assertEquals("name", violation.getPropertyPath().toString());
        }
    }

    @Test
    void shouldFailWhenNameIsOnlySpaces(){
        validUser.setName("   ");

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("name", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void shouldFailWhenNameIsNull(){
        validUser.setName(null);

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("name", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void shouldFailWhenNameIsShorterThanTwoCharacters() {
        validUser.setName("A");

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("name", violations.iterator().next().getPropertyPath().toString());
    }


    @Test
    void shouldFailWhenNameIsLongerThanOneHundredCharacters() {
        validUser.setName("A".repeat(101));

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("name", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void shouldFailWhenSurnameIsBlank(){
        validUser.setSurname("");

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertFalse(violations.isEmpty());
        assertEquals(2, violations.size());
        for (ConstraintViolation<User> violation : violations) {
            assertEquals("surname", violation.getPropertyPath().toString());
        }
    }

    @Test
    void shouldFailWhenSurnameIsOnlySpaces(){
        validUser.setSurname("   ");

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("surname", violations.iterator().next().getPropertyPath().toString());

    }

    @Test
    void shouldFailWhenSurnameIsNull(){
        validUser.setSurname(null);

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("surname", violations.iterator().next().getPropertyPath().toString());

    }

    @Test
    void shouldFailWhenSurnameIsShorterThanTwoCharacters() {
        validUser.setSurname("A");

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("surname", violations.iterator().next().getPropertyPath().toString());
    }


    @Test
    void shouldFailWhenSurnameIsLongerThanOneHundredCharacters() {
        validUser.setSurname("A".repeat(101));

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("surname", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void shouldPassWhenEmailIsValid(){
        validUser.setEmail("test@email.com");

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertTrue(violations.isEmpty());
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
    void shouldFailWhenEmailIsBlank(){
        validUser.setEmail("");

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("email", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void shouldFailWhenEmailIsNull(){
        validUser.setEmail(null);

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("email", violations.iterator().next().getPropertyPath().toString());

    }



    @Test
    void shouldFailWhenPasswordIsNull(){
        validUser.setPassword(null);

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("password", violations.iterator().next().getPropertyPath().toString());

    }

    @Test
    void shouldFailWhenPasswordIsBlank(){
        validUser.setPassword("");

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertFalse(violations.isEmpty());
        assertEquals(2, violations.size());
        for (ConstraintViolation<User> violation : violations) {
            assertEquals("password", violation.getPropertyPath().toString());
        }
    }

    @Test
    void shouldFailWhenPasswordIsOnlySpaces(){
        validUser.setPassword("    ");

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertFalse(violations.isEmpty());
        assertEquals(2, violations.size());
        for (ConstraintViolation<User> violation : violations) {
            assertEquals("password", violation.getPropertyPath().toString());
        }
    }

    @Test
    void shouldFailWhenPasswordIsShorterThanEightCharacters() {
        validUser.setPassword("Pass567");

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("password", violations.iterator().next().getPropertyPath().toString());

    }

    @Test
    void shouldFailWhenPasswordHasNoDigit(){
        validUser.setPassword("Passwordd");

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("password", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void shouldFailWhenPasswordHasNoUppercaseCharacter(){
        validUser.setPassword("password1234");

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("password", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void shouldFailWhenPasswordHasNoLowercaseCharacter(){
        validUser.setPassword("PASSWORD1234");

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("password", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void shouldPassWhenPasswordHasEightValidCharacters(){
        validUser.setPassword("Pass1234");

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertTrue(violations.isEmpty(), "Password must contain eight valid characters");
    }

    @Test
    void shouldFailWhenRoleIsNull(){
        validUser.setRole(null);

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("role", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void shouldPassWhenRoleIsClient(){
        validUser.setRole(Role.CLIENT);

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertTrue(violations.isEmpty());
    }

    @Test
    void shouldPassWhenRoleIsTrainer(){
        validUser.setRole(Role.TRAINER);

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertTrue(violations.isEmpty());
    }

    @Test
    void shouldPassWhenTrainerIsNull(){
        validUser.setTrainer(null);

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);

        assertTrue(violations.isEmpty());
    }


}
