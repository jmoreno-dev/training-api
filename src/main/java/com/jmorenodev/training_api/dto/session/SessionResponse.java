package com.jmorenodev.training_api.dto.session;

import com.jmorenodev.training_api.model.Routine;

import java.time.LocalDate;

public record SessionResponse(
        Long id,
        LocalDate date,
        Long userId,
        Long routineId
) {
}
