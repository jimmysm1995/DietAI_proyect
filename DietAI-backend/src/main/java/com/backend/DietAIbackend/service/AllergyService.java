package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Allergy;

import java.util.List;

public interface AllergyService {
    List<Allergy> findAll();
}
