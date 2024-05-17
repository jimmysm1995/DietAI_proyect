package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.exception.ServiceException;
import com.backend.DietAIbackend.model.Ingredient;
import com.backend.DietAIbackend.repository.IngredientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
        } catch (ServiceException e) {
            throw new ServiceException("El ingrediente ya existe en la base de datos", HttpStatus.CONFLICT.value());
        }
    }

    public Ingredient findById(Long id){
        return ingredientRepository.findById(id).orElseThrow(
                () -> new ServiceException("No se ha encontrado el ingrediente", HttpStatus.NOT_FOUND.value())
        );
    }

    public List<Ingredient> findAll(){
        if (ingredientRepository.findAllByOrderByNameAsc().isEmpty()){
            throw new ServiceException("No se encuentran Ingredientes", HttpStatus.NOT_FOUND.value());
        }
        return ingredientRepository.findAllByOrderByNameAsc();}

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
