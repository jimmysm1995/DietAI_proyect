package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.IngredientDto;
import com.backend.DietAIbackend.exception.ServiceException;
import com.backend.DietAIbackend.mapper.IngredientMapper;
import com.backend.DietAIbackend.model.Ingredient;
import com.backend.DietAIbackend.service.IngredientService;
import com.backend.DietAIbackend.service.IngredientServiceImp;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredient")
@CrossOrigin(origins = "${cors.allowed.origin}")
@Slf4j
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    @Autowired
    IngredientMapper ingredientMapper;

    @PostMapping
    public ResponseEntity<?> guardarIngrediente(@RequestBody IngredientDto ingredientDto) {
        try {
            Ingredient ingredient = ingredientMapper.dtoToModel(ingredientDto);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(ingredientMapper.modelToDto(ingredientService.save(ingredient)));
        } catch (ServiceException e) {
            return ResponseEntity.status(e.getHttpStatus())
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?>getAllIngredient(){
        try {
            return ResponseEntity.ok().body(ingredientService.findAll());
        }catch (ServiceException e){
            return ResponseEntity.status(e.getHttpStatus())
                    .body(e.getMessage());
        }

    }

    @GetMapping("/{idIngredient}")
    public ResponseEntity<?>getIngredientById(@PathVariable Long idIngredient){
        try {
            return ResponseEntity.ok().body(ingredientMapper.modelToDto(ingredientService.findById(idIngredient)));
        } catch (ServiceException e){
            return ResponseEntity.status(e.getHttpStatus())
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{idIngredient}")
    public ResponseEntity<?>deleteIngredient(@PathVariable Long idIngredient){
        try {
            ingredientService.deleteById(idIngredient);
        } catch (ServiceException e){
            log.error("Ha habido un problema al borrar el ingrediente");
            throw new ServiceException("El ingrediente no se ha podido eliminar");
        }
        return ResponseEntity.noContent().build();
    }
}
