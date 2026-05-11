package com.jmorenodev.training_api.dto.exercise;

import com.jmorenodev.training_api.model.enums.Muscles;

public record ExerciseResponse(
        Long id,
        String name,
        String description,
        Muscles muscles
) {
}
