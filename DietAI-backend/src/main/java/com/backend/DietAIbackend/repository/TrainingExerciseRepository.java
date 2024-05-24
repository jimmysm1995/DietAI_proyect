package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.model.TrainingExercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingExerciseRepository extends JpaRepository<TrainingExercise,Long> {

    List<TrainingExercise> findByExerciseIdExercise(long idExercicse);
}
