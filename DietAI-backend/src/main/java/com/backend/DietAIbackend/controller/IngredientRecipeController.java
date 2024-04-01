package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.IngredientRecipeDto;
import com.backend.DietAIbackend.mapper.IngredientRecipeMapper;
import com.backend.DietAIbackend.model.IngredientRecipe;
import com.backend.DietAIbackend.service.IngredientRecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredientRecipe")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class IngredientRecipeController {

    @Autowired
    IngredientRecipeService ingredientRecipeService;

    @Autowired
    IngredientRecipeMapper ingredientRecipeMapper;

    @PostMapping
    public ResponseEntity<IngredientRecipeDto> save(@RequestBody IngredientRecipeDto ingredientRecipeDto){

        IngredientRecipe ingredientRecipe = ingredientRecipeMapper.dtoToModel(ingredientRecipeDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(ingredientRecipeMapper.modelToDto(ingredientRecipeService.save(ingredientRecipe)));
    }

    @GetMapping
    public ResponseEntity<List<IngredientRecipeDto>>getAllIngredient(){

        return ResponseEntity.ok().body(ingredientRecipeMapper.listModelToDto(ingredientRecipeService.findAll()));
    }
}
