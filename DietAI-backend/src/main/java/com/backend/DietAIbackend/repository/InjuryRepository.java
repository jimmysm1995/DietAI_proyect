package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.model.Injury;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InjuryRepository extends JpaRepository<Injury, Long> {
}
