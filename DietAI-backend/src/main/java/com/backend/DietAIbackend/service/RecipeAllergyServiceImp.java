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

    @Override
    public List<RecipeAllergy> findAll() {
        return recipeAllergyRepository.findAll();
    }

    @Override
    public RecipeAllergy findById(Long var1) {
        return recipeAllergyRepository.findById(var1).orElse(null);
    }

    @Override
    public RecipeAllergy save(Recipe recipe, Allergy allergy) {
        RecipeAllergy recipeAllergy = new RecipeAllergy();

        recipeAllergy.setRecipe(recipe);
        recipeAllergy.setAllergy(allergy);

        return recipeAllergyRepository.save(recipeAllergy);
    }

    @Override
    public void deleteById(Long var1) {
        recipeAllergyRepository.deleteById(var1);
    }

    @Override
    public RecipeAllergy update(RecipeAllergy var1) {
        try {
            recipeAllergyRepository.findById(var1.getIdRecipeAllergy());
        } catch (EntityNotFoundException e){
            throw new ServiceException("No exista la relación en cuestion");
        }

        return recipeAllergyRepository.save(var1);
    }
}
