package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.*;

import java.util.List;

public interface DietAllergyService{
    List<DietAllergy> findAll();
    DietAllergy findById(Long var1);
    DietAllergy save(Diet diet, Allergy allergy);
    void deleteById(Long var1);
    DietAllergy update(DietAllergy var1);
}
