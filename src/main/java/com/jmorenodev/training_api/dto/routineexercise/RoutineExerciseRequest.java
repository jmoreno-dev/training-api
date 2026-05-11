package com.jmorenodev.training_api.dto.routineexercise;

import com.jmorenodev.training_api.model.Exercise;
import com.jmorenodev.training_api.model.Routine;
import com.jmorenodev.training_api.model.enums.Rpe;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record RoutineExerciseRequest(

        @PositiveOrZero
        Double targetWeight,

        @NotNull
        @Positive
        Integer targetReps,

        Rpe targetRpe,

        @PositiveOrZero
        Integer targetRestSeconds,

        @NotNull
        Exercise exercise,

        @NotNull
        Routine routine
) {
}
