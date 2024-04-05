package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.ClientDto;
import com.backend.DietAIbackend.dto.IngredientDto;
import com.backend.DietAIbackend.mapper.IngredientMapper;
import com.backend.DietAIbackend.model.Client;
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
    public ResponseEntity<IngredientDto> guardarIngrediente(@RequestBody IngredientDto ingredientDto){

        Ingredient ingredient = ingredientMapper.dtoToModel(ingredientDto);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(ingredientMapper.modelToDto(ingredientService.save(ingredient)));
    }

    @GetMapping
    public ResponseEntity<List<Ingredient>>getAllIngredient(){

        return ResponseEntity.ok().body(ingredientService.findAll());
    }

    @GetMapping("/{idIngredient}")
    public ResponseEntity<IngredientDto>getIngredientById(@PathVariable Long idIngredient){

        return ResponseEntity.ok().body(ingredientMapper.modelToDto(ingredientService.findById(idIngredient)));
    }
}
