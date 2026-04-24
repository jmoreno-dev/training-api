package com.jmorenodev.training_api.model;

import com.jmorenodev.training_api.model.enums.Muscles;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 100)
    private String name;

    @Size (max = 255)
    private String description;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Muscles muscleGroup;
}
