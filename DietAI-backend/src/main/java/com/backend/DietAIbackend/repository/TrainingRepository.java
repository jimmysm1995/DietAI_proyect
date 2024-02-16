package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<Training,Long> {
}
