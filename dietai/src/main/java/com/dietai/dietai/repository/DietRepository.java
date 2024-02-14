package com.dietai.dietai.repository;


import com.dietai.dietai.model.Diet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietRepository extends JpaRepository<Diet,Long> {
}
