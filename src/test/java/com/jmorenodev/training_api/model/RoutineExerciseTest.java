package com.jmorenodev.training_api.model;

import com.jmorenodev.training_api.model.enums.Muscles;
import com.jmorenodev.training_api.model.enums.Role;
import com.jmorenodev.training_api.model.enums.Rpe;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RoutineExerciseTest {

    private Validator validator;
    private RoutineExercise validRoutineExercise;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        Exercise exercise = new Exercise(1L, "Squat", "description", Muscles.ABS);
        User user = new User(1L, "Juan", "Moreno", "juan@test.com", "12345678", Role.CLIENT, null);
        Routine routine = new Routine(1L, "Heavy leg day", user);

        validRoutineExercise = new RoutineExercise(1L, 25.5, 4, Rpe.RPE_8, 30, exercise, routine);
    }

    @Test
    void shouldPassValidationWhenAllFieldsAreValid(){
        assertNotNull(validRoutineExercise);

        Set<ConstraintViolation<RoutineExercise>> violations = validator.validate(validRoutineExercise);

        assertTrue(violations.isEmpty());
    }

    @Test
    void shouldPassWhenTargetWeightIsZero(){
        validRoutineExercise.setTargetWeight(0.0);

        Set<ConstraintViolation<RoutineExercise>> violations = validator.validate(validRoutineExercise);

        assertTrue(violations.isEmpty(), "It should accept 0 for bodyweight exercises: "+violations);
    }

    @Test
    void shouldFailWhenTargetWeightIsNegative(){
        validRoutineExercise.setTargetWeight(-4.0);

        Set<ConstraintViolation<RoutineExercise>> violations = validator.validate(validRoutineExercise);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("targetWeight", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void shouldFailWhenTargetRepsAreNegative(){
        validRoutineExercise.setTargetReps(-1);

        Set<ConstraintViolation<RoutineExercise>> violations = validator.validate(validRoutineExercise);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("targetReps", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void shouldFailWhenTargetRepsAreZero(){
        validRoutineExercise.setTargetReps(0);

        Set<ConstraintViolation<RoutineExercise>> violations = validator.validate(validRoutineExercise);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("targetReps", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void shouldFailWhenTargetRestSecondsAreNegative(){
        validRoutineExercise.setTargetRestSeconds(-1);

        Set<ConstraintViolation<RoutineExercise>> violations = validator.validate(validRoutineExercise);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("targetRestSeconds", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void shouldFailWhenExerciseIsNull(){
        validRoutineExercise.setExercise(null);

        Set<ConstraintViolation<RoutineExercise>> violations = validator.validate(validRoutineExercise);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("exercise", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void shouldFailWhenRoutineIsNull(){
        validRoutineExercise.setRoutine(null);

        Set<ConstraintViolation<RoutineExercise>> violations = validator.validate(validRoutineExercise);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("routine", violations.iterator().next().getPropertyPath().toString());
    }

}