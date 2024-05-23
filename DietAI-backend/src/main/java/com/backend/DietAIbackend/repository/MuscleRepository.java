package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.model.Ingredient;
import com.backend.DietAIbackend.model.Muscle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MuscleRepository extends JpaRepository<Muscle, Long> {

    List<Muscle> findAllByOrderByNameAsc();
}
