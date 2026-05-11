package com.jmorenodev.training_api.dto.user;

import com.jmorenodev.training_api.model.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequest(

@NotBlank
@Size(min = 2, max = 100)
String name,

@NotBlank
@Size (min = 2, max = 100)
String surname,

@Email
@NotBlank
String email,

@NotBlank
@Size (max = 255)
String password,

@NotNull
Role role,

Long trainerId
) {}
