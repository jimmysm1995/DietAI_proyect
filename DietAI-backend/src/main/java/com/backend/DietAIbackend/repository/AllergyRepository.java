package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.model.Allergy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllergyRepository extends JpaRepository<Allergy, Long> {
}
