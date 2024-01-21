package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.model.Dieta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietaRepository extends JpaRepository<Dieta,Long> {
}
