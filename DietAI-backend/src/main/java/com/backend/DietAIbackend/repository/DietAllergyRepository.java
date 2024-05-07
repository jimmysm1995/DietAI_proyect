package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.model.DietAllergy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietAllergyRepository extends JpaRepository<DietAllergy, Long> {
}
