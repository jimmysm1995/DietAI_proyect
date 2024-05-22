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
    public ResponseEntity<IngredientDto> guardarIngrediente(@RequestBody IngredientDto ingredientDto) {
            Ingredient ingredient = ingredientMapper.dtoToModel(ingredientDto);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(ingredientMapper.modelToDto(ingredientService.save(ingredient)));
    }

    @GetMapping
    public ResponseEntity<List<IngredientDto>>getAllIngredient(){
            return ResponseEntity.ok().body(ingredientMapper.listModelToDto(ingredientService.findAll()));

    }

    @GetMapping("/{idIngredient}")
    public ResponseEntity<IngredientDto>getIngredientById(@PathVariable Long idIngredient){
            return ResponseEntity.ok().body(ingredientMapper.modelToDto(ingredientService.findById(idIngredient)));
    }

    @DeleteMapping("/{idIngredient}")
    public ResponseEntity<Void>deleteIngredient(@PathVariable Long idIngredient){
        ingredientService.deleteById(idIngredient);
        return ResponseEntity.noContent().build();
    }
}
