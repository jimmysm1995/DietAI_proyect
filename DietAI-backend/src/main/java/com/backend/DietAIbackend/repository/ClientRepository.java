package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client,Long> {
    @Query("SELECT c FROM Client c WHERE c.user.id = :userId")
    Client findClientByUserId(@Param("userId") Long userId);
}
