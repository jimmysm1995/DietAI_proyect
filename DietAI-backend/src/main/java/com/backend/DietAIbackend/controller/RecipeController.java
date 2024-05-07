package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.IngredientInRecipe;
import com.backend.DietAIbackend.dto.RecipeDto;
import com.backend.DietAIbackend.dto.RecipeWithIngredientsRequest;
import com.backend.DietAIbackend.mapper.AllergyMapper;
import com.backend.DietAIbackend.mapper.RecipeMapper;
import com.backend.DietAIbackend.model.Allergy;
import com.backend.DietAIbackend.model.Recipe;
import com.backend.DietAIbackend.service.RecipeService;
import com.backend.DietAIbackend.service.RecipeServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe")
@CrossOrigin(origins = "${cors.allowed.origin}")
@Slf4j
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeMapper recipeMapper;

    @Autowired
    AllergyMapper allergyMapper;

    @PostMapping
    public ResponseEntity<RecipeDto> save(@RequestBody RecipeWithIngredientsRequest request) {

        Recipe recipe = recipeMapper.dtoToModel(request.getRecipe());
        List<IngredientInRecipe> ingredientInRecipeList = request.getIngredientInRecipe();
        List<Allergy> allergyList = allergyMapper.listDtoToModel(request.getRecipe().getAllergy());

        return ResponseEntity.ok().body(recipeMapper.modelToDto(recipeService.save(recipe, ingredientInRecipeList, allergyList)));
    }

    @GetMapping
    public ResponseEntity<List<RecipeDto>>findAll(){

        return ResponseEntity.ok().body(recipeMapper.listModelToDto(recipeService.findAll()));
    }

    @GetMapping("/recipesWithIngredient/{idRecipe}")
    public ResponseEntity<RecipeWithIngredientsRequest> getRecipeWithIngredients(@PathVariable Long idRecipe){

        return ResponseEntity.ok().body(recipeService.getRecipeWithIngredients(idRecipe));

    }

    @DeleteMapping("/{idRecipe}")
    public ResponseEntity<Void>deleteRecipe(@PathVariable Long idRecipe){

        try {
            recipeService.deleteById(idRecipe);
        } catch (Exception e){
            log.error("Ha habido un problema al borrar la receta");
        }
        return ResponseEntity.noContent().build();
    }

}
