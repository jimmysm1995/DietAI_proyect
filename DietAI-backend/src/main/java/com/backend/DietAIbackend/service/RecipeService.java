package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Recipe;
import com.backend.DietAIbackend.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recetaRepository;

    public void crearReceta(Recipe receta){
        recetaRepository.save(receta);
    }

    public void eliminarReceta(Recipe receta){
        recetaRepository.delete(receta);
    }

    public Recipe findReceta(Long id){
        return recetaRepository.findById(id).orElse(null);
    }

    public List<Recipe> findAllReceta(){
        return recetaRepository.findAll();
    }
}
