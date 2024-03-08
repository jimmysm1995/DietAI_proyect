package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.IngredientDto;
import com.backend.DietAIbackend.mapper.IngredientMapper;
import com.backend.DietAIbackend.model.Ingredient;
import com.backend.DietAIbackend.service.IngredientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ingredient")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    @Autowired
    IngredientMapper ingredientMapper;

    @PostMapping("/register")

    public ResponseEntity<Ingredient> guardarIngrediente(@RequestBody IngredientDto ingredientDto){

        log.info(ingredientDto.getName());

        Ingredient ingredient = ingredientMapper.dtoToModel(ingredientDto);

        log.info(ingredient.getName());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(ingredientService.registerIngredient(ingredient));

    }
}
