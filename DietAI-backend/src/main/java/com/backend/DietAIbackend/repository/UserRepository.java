package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String userame);

    Optional<User> findByEmail(String email);
}
