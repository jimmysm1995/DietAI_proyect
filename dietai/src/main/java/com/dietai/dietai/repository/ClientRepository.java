package com.dietai.dietai.repository;

import com.dietai.dietai.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
