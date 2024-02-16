package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.model.Diet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietRepository extends JpaRepository<Diet,Long> {
}
