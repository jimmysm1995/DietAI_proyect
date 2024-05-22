package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.exception.ServiceException;
import com.backend.DietAIbackend.model.Ingredient;
import com.backend.DietAIbackend.repository.IngredientRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class IngredientServiceImp implements IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    @Transactional
    @Override
    public Ingredient save(Ingredient ingredient) {
        try {
            return ingredientRepository.save(ingredient);
        } catch (DataIntegrityViolationException e) {
            throw new ServiceException("Ya existe un ingrediente con este nombre", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Ingredient findById(Long id) {
        return ingredientRepository.findById(id)
                .orElseThrow(() -> new ServiceException("No se ha encontrado el ingrediente", HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Ingredient> findAll() {
        List<Ingredient> ingredients = ingredientRepository.findAllByOrderByNameAsc();
        if (ingredients.isEmpty()) {
            throw new ServiceException("No se encuentran ingredientes", HttpStatus.NOT_FOUND);
        }
        return ingredients;
    }

    @Override
    public void deleteById(Long id) {
        ingredientRepository.findById(id).ifPresentOrElse(
                ingredientRepository::delete,
                () -> {
                    throw new ServiceException("El ingrediente no existe", HttpStatus.NOT_FOUND);
                }
        );
    }

    @Override
    public Ingredient update(Ingredient ingredient) {
        if (!ingredientRepository.existsById(ingredient.getIdIngredient())) {
            throw new ServiceException("No se encontró el ingrediente para actualizar", HttpStatus.NOT_FOUND);
        }
        return ingredientRepository.save(ingredient);
    }
}

