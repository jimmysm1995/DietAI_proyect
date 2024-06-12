package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.AllergyDto;
import com.backend.DietAIbackend.dto.IngredientInRecipe;
import com.backend.DietAIbackend.dto.RecipeDto;
import com.backend.DietAIbackend.dto.RecipeWithIngredientsRequest;
import com.backend.DietAIbackend.mapper.AllergyMapper;
import com.backend.DietAIbackend.mapper.RecipeMapper;
import com.backend.DietAIbackend.model.Allergy;
import com.backend.DietAIbackend.model.Recipe;
import com.backend.DietAIbackend.service.RecipeService;
import com.backend.DietAIbackend.service.RecipeServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe")
@CrossOrigin(origins = "${cors.allowed.origin}")
@Tag(name = "RecipeController", description = "Endpoint para las recetas")
@Slf4j
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeMapper recipeMapper;

    @Autowired
    AllergyMapper allergyMapper;

    @PostMapping
    @Operation(summary = "Guarda una receta")
    public ResponseEntity<RecipeDto> save(@RequestBody RecipeWithIngredientsRequest request) {

        Recipe recipe = recipeMapper.dtoToModel(request.getRecipe());
        List<IngredientInRecipe> ingredientInRecipeList = request.getIngredientInRecipe();
        List<Allergy> allergyList = allergyMapper.listDtoToModel(request.getRecipe().getAllergy());

        return ResponseEntity.ok().body(recipeMapper.modelToDto(recipeService.save(recipe, ingredientInRecipeList, allergyList)));
    }

    @GetMapping
    @Operation(summary = "Devuelve una lista con las recetas")
    public ResponseEntity<List<RecipeDto>>findAll(){

        return ResponseEntity.ok().body(recipeMapper.listModelToDto(recipeService.findAll()));
    }

    @GetMapping("/recipesWithIngredient/{idRecipe}")
    @Operation(summary = "Devuelve una receta con una lista de sus ingredientes junto a sus cantidades")
    public ResponseEntity<RecipeWithIngredientsRequest> getRecipeWithIngredients(@PathVariable Long idRecipe){

        return ResponseEntity.ok().body(recipeService.getRecipeWithIngredients(idRecipe));

    }

    @DeleteMapping("/{idRecipe}")
    @Operation(summary = "Devuelve una receta con una lista de sus ingredientes junto a sus cantidades")
    public ResponseEntity<Void>deleteRecipe(@PathVariable Long idRecipe){
        recipeService.deleteById(idRecipe);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/allergies/{idRecipe}")
    @Operation(summary = "Devuelve una lista con todas las alergias de una receta")
    public ResponseEntity<List<AllergyDto>> findAllAllergiesInRecipe(@PathVariable Long idRecipe){

        return ResponseEntity.ok().body(allergyMapper.listModelToDto(recipeService.findAllAllergiesInRecipe(idRecipe)));
    }

}
