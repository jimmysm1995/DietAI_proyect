package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.model.Ingredient;
import com.backend.DietAIbackend.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingRepository extends JpaRepository<Training,Long> {

    List<Training> findAllByOrderByNameAsc();
}
