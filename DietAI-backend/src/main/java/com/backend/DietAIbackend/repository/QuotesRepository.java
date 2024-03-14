package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.model.Quotes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuotesRepository extends JpaRepository<Quotes, Long> {

}
