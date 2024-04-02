package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.ExerciseDto;
import com.backend.DietAIbackend.dto.IngredientInRecipe;
import com.backend.DietAIbackend.dto.RecipeDto;
import com.backend.DietAIbackend.dto.RecipeWithIngredientsRequest;
import com.backend.DietAIbackend.mapper.RecipeMapper;
import com.backend.DietAIbackend.model.Exercise;
import com.backend.DietAIbackend.model.IngredientRecipe;
import com.backend.DietAIbackend.model.Recipe;
import com.backend.DietAIbackend.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeMapper recipeMapper;

    @PostMapping("/actualizar")
    public void actualizarCalorias(){
        recipeService.actualizarCalorias();
    }

    @PostMapping
    public ResponseEntity<RecipeDto> save(@RequestBody RecipeWithIngredientsRequest request) {

        Recipe recipe = recipeMapper.dtoToModel(request.getRecipe());
        List<IngredientInRecipe> ingredientInRecipeList = request.getIngredientInRecipe();

        return ResponseEntity.ok().body(recipeMapper.modelToDto(recipeService.save(recipe, ingredientInRecipeList)));
    }

    @GetMapping
    public ResponseEntity<List<RecipeDto>>findAll(){

        return ResponseEntity.ok().body(recipeMapper.listModelToDto(recipeService.findAll()));
    }

}
