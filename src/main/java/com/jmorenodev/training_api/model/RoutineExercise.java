package com.jmorenodev.training_api.model;

import com.jmorenodev.training_api.model.enums.Rpe;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table (name = "routine_exercises")
@NoArgsConstructor
@AllArgsConstructor
public class RoutineExercise {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "target_weight")
    @Positive
    private Double targetWeight;

    @Column (name = "target_reps")
    @NotNull
    @Positive
    private Integer targetReps;

    @Enumerated (EnumType.STRING)
    private Rpe targetRpe;

    @Column (name = "target_rest_seconds")
    private double targetRestSeconds;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    @NotNull
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name = "routine_id")
    @NotNull
    private Routine routine;

}
