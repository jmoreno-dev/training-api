package com.jmorenodev.training_api.dto.user;

import com.jmorenodev.training_api.model.enums.Role;

public record UserResponse(
Long id,
String name,
String surname,
String email,
Role role,
Long trainerId
 ) {}
