package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String userame);

    Optional<User> findByUsernameOrEmail(String username, String email);

    Optional<User> findByEmail(String email);
}
