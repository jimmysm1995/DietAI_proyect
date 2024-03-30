package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise,Long> {
}
