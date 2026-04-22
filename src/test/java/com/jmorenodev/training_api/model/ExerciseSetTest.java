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

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseSetTest {

    private Validator validator;
    private ExerciseSet validExerciseSet;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        User user = new User(1L, "name", "surname", "email@email.com", "12345678", Role.CLIENT, null);
        Routine routine =  new Routine(1L, "name", user);
        Exercise exercise = new Exercise(1L, "coercion", "description", Muscles.ABS);
        Session session = new Session(1L, LocalDate.now(), user, routine);

        validExerciseSet = new ExerciseSet(1L, 2, 25.5, 4, Rpe.RPE_8, 120, exercise, session);
    }

    @Test
    void shouldPassValidationWhenAllFieldsAreValid(){
        assertNotNull(validExerciseSet);

        Set<ConstraintViolation<ExerciseSet>> violations = validator.validate(validExerciseSet);

        assertTrue(violations.isEmpty());
    }

    @Test
    void shouldFailSetting0ToSetNumber(){
        validExerciseSet.setSetNumber(0);

        Set<ConstraintViolation<ExerciseSet>> violations = validator.validate(validExerciseSet);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("setNumber", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void shouldFailSettingNegativeWeight(){
        validExerciseSet.setWeight(-3.0);

        Set<ConstraintViolation<ExerciseSet>> violations = validator.validate(validExerciseSet);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("weight", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void shouldFailSettingNegativeReps(){
        validExerciseSet.setReps(-1);

        Set<ConstraintViolation<ExerciseSet>> violations = validator.validate(validExerciseSet);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("reps", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void shouldFailSettingNegativeRestSeconds(){
        validExerciseSet.setRestSeconds(-60);

        Set<ConstraintViolation<ExerciseSet>> violations = validator.validate(validExerciseSet);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("restSeconds", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void shouldFailSettingNullExercise(){
        validExerciseSet.setExercise(null);

        Set<ConstraintViolation<ExerciseSet>> violations = validator.validate(validExerciseSet);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("exercise", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void shouldFailSettingNullSession(){
        validExerciseSet.setSession(null);

        Set<ConstraintViolation<ExerciseSet>> violations = validator.validate(validExerciseSet);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        assertEquals("session", violations.iterator().next().getPropertyPath().toString());
    }
}