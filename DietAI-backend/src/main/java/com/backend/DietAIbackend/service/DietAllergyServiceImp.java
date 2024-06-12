package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Allergy;
import com.backend.DietAIbackend.model.Diet;
import com.backend.DietAIbackend.model.DietAllergy;
import com.backend.DietAIbackend.model.RecipeAllergy;
import com.backend.DietAIbackend.repository.DietAllergyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DietAllergyServiceImp implements DietAllergyService{

    @Autowired
    DietAllergyRepository dietAllergyRepository;

    /**
     *
     * Guarda las alergias que contiene la dieta
     *
     * @param diet
     * @param allergy
     * @return
     */
    @Override
    public DietAllergy save(Diet diet, Allergy allergy) {
        try {
            DietAllergy dietAllergy = DietAllergy.builder()
                    .diet(diet)
                    .allergy(allergy)
                    .build();

            return dietAllergyRepository.save(dietAllergy);
        } catch (Exception e){
            throw e;
        }

    }

}
