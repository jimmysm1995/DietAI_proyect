package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.*;
import com.backend.DietAIbackend.mapper.AllergyMapper;
import com.backend.DietAIbackend.mapper.DietMapper;
import com.backend.DietAIbackend.mapper.RecipeMapper;
import com.backend.DietAIbackend.model.Allergy;
import com.backend.DietAIbackend.model.Diet;
import com.backend.DietAIbackend.service.DietService;
import com.backend.DietAIbackend.service.DietServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diet")
@CrossOrigin(origins = "${cors.allowed.origin}")
@Slf4j
@Tag(name = "DietController", description = "Endpoint para las dietas")
public class DietController {

    @Autowired
    DietService dietService;

    @Autowired
    DietMapper dietMapper;


    @Autowired
    AllergyMapper allergyMapper;

    @GetMapping
    @Operation(summary = "Devuelve una lista con todas las dietas")
    public ResponseEntity<List<DietDto>>findAll(){

        return ResponseEntity.ok().body(dietMapper.listModelToDto(dietService.findAll()));
    }

    @GetMapping("/recipes/{id}")
    @Operation(summary = "Devuelve una lista con las recetas de una dieta")
    public ResponseEntity<List<RecipeInDiet>> findRecipesByDiet(@PathVariable Long id){

        List<RecipeInDiet> recipeList = dietService.findRecipesByDiet(id);

        return ResponseEntity.ok().body(recipeList);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Devuelve una dieta según su id")
    public ResponseEntity<DietDto> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(dietMapper.modelToDto(dietService.findById(id)));
    }

    @GetMapping("/listaCompra/{id}")
    @Operation(summary = "Devuelve la lista de la compra semanal de una dieta")
    public ResponseEntity<List<IngredientSummary>> getListaCompra(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(dietService.getListaCompra(id));
    }

    @PostMapping
    @Operation(summary = "Guarda una dieta")
    public ResponseEntity<DietDto> save(@RequestBody DietWithRecipesRequest request){

        Diet diet = dietMapper.dtoToModel(request.getDiet());

        List<RecipeInDiet> recipeInDietList = request.getRecipeInDiet();

        List<Allergy> allergyList = allergyMapper.listDtoToModel(request.getDiet().getAllergy());

        return ResponseEntity.ok().body(dietMapper.modelToDto(dietService.save(diet, recipeInDietList, allergyList)));
    }

    @DeleteMapping("/{idDiet}")
    @Operation(summary = "Elimina una dieta por su id")
    public ResponseEntity<Void>deleteDiet(@PathVariable Long idDiet){
        dietService.deleteById(idDiet);
        return ResponseEntity.noContent().build();
    }

}
