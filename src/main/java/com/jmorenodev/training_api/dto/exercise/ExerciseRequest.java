package com.jmorenodev.training_api.dto.exercise;

import com.jmorenodev.training_api.model.enums.Muscles;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ExerciseRequest(

        @NotBlank
        @Size(min = 2, max = 100)
        String name,

        @Size(max = 255)
        String description,

        @NotNull
        Muscles muscleGroup
) {
}
