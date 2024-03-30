package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.RecipeInDiet;
import com.backend.DietAIbackend.mapper.DietMapper;
import com.backend.DietAIbackend.mapper.RecipeMapper;
import com.backend.DietAIbackend.service.DietService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diet")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class DietController {

    @Autowired
    DietService dietService;

    @Autowired
    DietMapper dietMapper;

    @Autowired
    RecipeMapper recipeMapper;

    @GetMapping("/recipes/{id}")
    public ResponseEntity<List<RecipeInDiet>> findRecipesByDiet(@PathVariable Long id){

        List<RecipeInDiet> recipeList = dietService.findRecipesByDiet(id);

        return ResponseEntity.ok().body(recipeList);

    }


}
