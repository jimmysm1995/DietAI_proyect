package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.model.Exercise;
import com.backend.DietAIbackend.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise,Long> {

    List<Exercise> findAllByOrderByNameAsc();
}
