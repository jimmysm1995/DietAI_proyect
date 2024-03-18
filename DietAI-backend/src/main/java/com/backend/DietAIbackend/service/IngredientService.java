package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Diet;
import com.backend.DietAIbackend.model.Ingredient;
import com.backend.DietAIbackend.repository.IngredientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    public Ingredient save(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    public Ingredient findById(Long id){
        return ingredientRepository.findById(id).orElse(null);
    }

    public List<Ingredient> findAll(){return ingredientRepository.findAll();}
    public void delete(Ingredient ingredient){ ingredientRepository.delete(ingredient);}

    public void deleteById(Long id){ ingredientRepository.deleteById(id);}

    public Ingredient update(Ingredient ingredient) {
        try {
            ingredientRepository.findById(ingredient.getId());
        } catch (EntityNotFoundException e){
            throw new ServiceException("No existe el cliente en cuestion");
        }

        return ingredientRepository.save(ingredient);
    }


}
