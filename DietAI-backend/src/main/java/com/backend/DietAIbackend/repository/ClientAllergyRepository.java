package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.model.ClientAllergy;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ClientAllergyRepository extends JpaRepository<ClientAllergy, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM ClientAllergy ca WHERE ca.client = :client")
    void deleteAllByClient(Client client);
}
