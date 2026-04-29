package com.jmorenodev.training_api.repository;

import com.jmorenodev.training_api.model.ExerciseSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseSetRepository extends JpaRepository<ExerciseSet, Long> {
}

