package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.model.TrainingExercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingExerciseRepository extends JpaRepository<TrainingExercise,Long> {
}
