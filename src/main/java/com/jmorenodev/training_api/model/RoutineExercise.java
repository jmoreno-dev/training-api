package com.jmorenodev.training_api.model;

import com.jmorenodev.training_api.model.enums.Rpe;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table (name = "routine_exercises")
public class RoutineExercise {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "target_weight")
    @NotNull
    private double targetWeight;

    @Column (name = "target_reps")
    @NotNull
    private int targetReps;

    @Enumerated (EnumType.STRING)
    private Rpe targetRpe;

    @Column (name = "target_seconds")
    private double targetSeconds;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name = "routine_id")
    private Routine routine;

}
