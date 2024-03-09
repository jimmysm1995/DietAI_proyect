package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Ingredient;
import com.backend.DietAIbackend.model.IngredientRecipe;
import com.backend.DietAIbackend.repository.IngredientRecipeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientRecipeService {

    @Autowired
    IngredientRecipeRepository ingredientRecipeRepository;

    public IngredientRecipe save(IngredientRecipe ingredientRecipe){
        return ingredientRecipeRepository.save(ingredientRecipe);
    }

    public IngredientRecipe findById(Long id){
        return ingredientRecipeRepository.findById(id).orElse(null);
    }

    public List<IngredientRecipe> findAll(){return ingredientRecipeRepository.findAll();}
    public void delete(IngredientRecipe ingredientRecipe){ ingredientRecipeRepository.delete(ingredientRecipe);}

    public void deleteById(Long id){ ingredientRecipeRepository.deleteById(id);}

    public IngredientRecipe update(IngredientRecipe ingredientRecipe) {
        try {
            ingredientRecipeRepository.findById(ingredientRecipe.getIdIngredientRecipe());
        } catch (EntityNotFoundException e){
            throw new ServiceException("No existe el cliente en cuestion");
        }

        return ingredientRecipeRepository.save(ingredientRecipe);
    }
}
