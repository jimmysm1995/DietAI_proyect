package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.model.ClientAllergy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientAllergyRepository extends JpaRepository<ClientAllergy, Long> {
}
