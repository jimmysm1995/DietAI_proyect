package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.model.ClientInjury;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ClientInjuryRepository extends JpaRepository<ClientInjury, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM ClientInjury ci WHERE ci.client = :client")
    void deleteAllByClient(Client client);
}
