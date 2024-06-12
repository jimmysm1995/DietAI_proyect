package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.IngredientDto;
import com.backend.DietAIbackend.mapper.IngredientMapper;
import com.backend.DietAIbackend.model.Ingredient;
import com.backend.DietAIbackend.service.IngredientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredient")
@CrossOrigin(origins = "${cors.allowed.origin}")
@Slf4j
@Tag(name = "IngredientController", description = "Endpoint para los ingredientes")
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    @Autowired
    IngredientMapper ingredientMapper;

    @PostMapping
    @Operation(summary = "Guarda un ingrediente")
    public ResponseEntity<IngredientDto> save(@RequestBody IngredientDto ingredientDto) {
            Ingredient ingredient = ingredientMapper.dtoToModel(ingredientDto);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(ingredientMapper.modelToDto(ingredientService.save(ingredient)));
    }

    @GetMapping
    @Operation(summary = "Devuelve una lista con todos los ingredientes")
    public ResponseEntity<List<IngredientDto>>findAll(){
            return ResponseEntity.ok().body(ingredientMapper.listModelToDto(ingredientService.findAll()));

    }

    @GetMapping("/{idIngredient}")
    @Operation(summary = "Devuelve un ingrediente según su id")
    public ResponseEntity<IngredientDto>findById(@PathVariable Long idIngredient){
            return ResponseEntity.ok().body(ingredientMapper.modelToDto(ingredientService.findById(idIngredient)));
    }

    @DeleteMapping("/{idIngredient}")
    @Operation(summary = "Elimina un ingrediente según su id")
    public ResponseEntity<Void>deleteById(@PathVariable Long idIngredient){
        ingredientService.deleteById(idIngredient);
        return ResponseEntity.noContent().build();
    }
}
