package com.jmorenodev.training_api.dto.session;

import com.jmorenodev.training_api.model.Routine;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record SessionRequest(

        @PastOrPresent
        @NotNull
        LocalDate date,

        @NotNull
        Long userId,

        @NotNull
        Long routineId) {
}
