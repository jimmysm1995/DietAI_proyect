package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.model.Receta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecetaRepository extends JpaRepository <Receta,Long> {
}
