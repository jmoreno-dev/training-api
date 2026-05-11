package com.jmorenodev.training_api.dto.exerciseset;

import com.jmorenodev.training_api.model.Exercise;
import com.jmorenodev.training_api.model.Session;
import com.jmorenodev.training_api.model.enums.Rpe;

public record ExerciseSetResponse(
        Long id,
        Integer setNumber,
        Double weight,
        Integer reps,
        Rpe rpe,
        Integer restSeconds,
        Long exerciseId,
        Long sessionId) {
}
