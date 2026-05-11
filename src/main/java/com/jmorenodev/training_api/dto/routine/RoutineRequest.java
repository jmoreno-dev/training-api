package com.jmorenodev.training_api.dto.routine;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RoutineRequest(

        @NotBlank
        @Size(min = 2, max = 100)
        String name,

        @NotNull
        Long userId
) {
}
