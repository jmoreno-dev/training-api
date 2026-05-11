package com.jmorenodev.training_api.dto.routineexercise;

import com.jmorenodev.training_api.model.Exercise;
import com.jmorenodev.training_api.model.Routine;
import com.jmorenodev.training_api.model.enums.Rpe;

public record RoutineExerciseResponse(
        Long id,
        Double targetWeight,
        Integer targetReps,
        Rpe targetRpe,
        Integer targetRestSeconds,
        Exercise exercise,
        Routine routine
) {
}
