package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.GymExercise;
import com.backend.DietAIbackend.model.Recipe;
import com.backend.DietAIbackend.repository.RecipeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recetaRepository;

    public void save(Recipe receta){
        recetaRepository.save(receta);
    }

    public void delete(Recipe receta){
        recetaRepository.delete(receta);
    }

    public Recipe findById(Long id){
        return recetaRepository.findById(id).orElse(null);
    }

    public List<Recipe> findAll(){
        return recetaRepository.findAll();
    }

    public Recipe update(Recipe recipe) {
        try {
            recetaRepository.findById(recipe.getId());
        } catch (EntityNotFoundException e){
            throw new ServiceException("No existe el cliente en cuestion");
        }
        return recetaRepository.save(recipe);
    }
}
