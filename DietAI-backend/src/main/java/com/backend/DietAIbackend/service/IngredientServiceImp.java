package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Ingredient;
import com.backend.DietAIbackend.repository.IngredientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class IngredientServiceImp implements IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    public Ingredient save(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    public Ingredient findById(Long id){
        return ingredientRepository.findById(id).orElse(null);
    }

    public List<Ingredient> findAll(){return ingredientRepository.findAll();}

    public void deleteById(Long id) {
        try {
            Ingredient ingredient = findById(id);
            if (ingredient == null){
                throw new ServiceException("El ingrediente no existe");
            }
            ingredientRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Ha habido un problema al borrar el ingrediente");
            throw new ServiceException("El ingrediente no se ha podido eliminar");
        }
    }

    public Ingredient update(Ingredient ingredient) {
        try {
            ingredientRepository.findById(ingredient.getIdIngredient());
        } catch (EntityNotFoundException e){
            throw new ServiceException("No existe el cliente en cuestion");
        }

        return ingredientRepository.save(ingredient);
    }


}
