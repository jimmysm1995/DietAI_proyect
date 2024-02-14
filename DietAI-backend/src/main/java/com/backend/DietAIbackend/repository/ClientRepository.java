package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
