package com.jmorenodev.training_api.model;

import com.jmorenodev.training_api.model.enums.Muscles;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseTest {

    private Validator validator;
    private Exercise validExercise;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        validExercise = new Exercise(1L, "name", "description", Muscles.BICEPS);
    }

    @Test
    void shouldPassValidationWhenAllFieldsAreValid(){
        assertNotNull(validExercise);

        Set<ConstraintViolation<Exercise>> violations = validator.validate(validExercise);

        assertTrue(violations.isEmpty());
    }

    @Test
    void shouldFailWithNameShorterThanTwoCharacters(){
        validExercise.setName("a");

        Set<ConstraintViolation<Exercise>> violations = validator.validate(validExercise);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("name", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void shouldFailWithNameLongerThanOneHundredCharacters(){
        String invalidName = "a";
        String newName = invalidName.repeat(101);
        validExercise.setName(newName);

        Set<ConstraintViolation<Exercise>> violations = validator.validate(validExercise);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("name", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void shouldFailWithDescriptionLargerThanTwoHundredAndFiftyFiveCharacters(){
        String invalidDescription = "b";
        String newDescription = invalidDescription.repeat(256);
        validExercise.setDescription(newDescription);

        Set<ConstraintViolation<Exercise>> violations = validator.validate(validExercise);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("description", violations.iterator().next().getPropertyPath().toString());
    }
}