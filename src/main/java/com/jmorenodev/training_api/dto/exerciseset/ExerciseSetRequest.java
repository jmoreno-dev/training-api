package com.jmorenodev.training_api.dto.exerciseset;

import com.jmorenodev.training_api.model.Exercise;
import com.jmorenodev.training_api.model.Session;
import com.jmorenodev.training_api.model.enums.Rpe;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record ExerciseSetRequest(
        @NotNull
        @Positive
        Integer setNumber,

        @PositiveOrZero
        Double weight,

        @NotNull
        @PositiveOrZero
        Integer reps,

        Rpe rpe,

        @PositiveOrZero
        Integer restSeconds,

        @NotNull
        Long exerciseId,
        @NotNull
        Long sessionId
) {
}
