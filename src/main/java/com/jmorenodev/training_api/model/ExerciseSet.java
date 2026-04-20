package com.jmorenodev.training_api.model;

import com.jmorenodev.training_api.model.enums.Rpe;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table (name = "exercise_sets")
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseSet {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Positive
    private Integer setNumber;

    @PositiveOrZero
    private double weight;

    @NotNull
    @PositiveOrZero
    private Integer reps;

    @Enumerated (EnumType.STRING)
    private Rpe rpe;

    @Column (name = "rest_seconds")
    private double restSeconds;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    @NotNull
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name = "session_id")
    @NotNull
    private Session session;
}
