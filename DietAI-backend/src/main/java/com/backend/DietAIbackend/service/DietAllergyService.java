package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.*;

import java.util.List;

public interface DietAllergyService{
    DietAllergy save(Diet diet, Allergy allergy);
}
