package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Allergy;
import com.backend.DietAIbackend.model.Recipe;
import com.backend.DietAIbackend.model.RecipeAllergy;
import com.backend.DietAIbackend.repository.RecipeAllergyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeAllergyServiceImp implements RecipeAllergyService{

    @Autowired
    RecipeAllergyRepository recipeAllergyRepository;

    /**
     * Guarda la relación entre receta y alergias
     *
     * @param recipe
     * @param allergy
     * @return
     */
    @Override
    public RecipeAllergy save(Recipe recipe, Allergy allergy) {

        return recipeAllergyRepository.save(RecipeAllergy.builder()
                        .recipe(recipe)
                        .allergy(allergy)
                        .build());
    }
}
