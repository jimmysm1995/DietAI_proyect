package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.AllergyDto;
import com.backend.DietAIbackend.dto.IngredientDto;
import com.backend.DietAIbackend.mapper.AllergyMapper;
import com.backend.DietAIbackend.model.Allergy;
import com.backend.DietAIbackend.model.Ingredient;
import com.backend.DietAIbackend.service.AllergyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/allergy")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class AllergyController {

    @Autowired
    AllergyService allergyService;

    @Autowired
    AllergyMapper allergyMapper;

    @PostMapping
    public ResponseEntity<AllergyDto> save(@RequestBody AllergyDto allergyDto){
        Allergy allergy = allergyMapper.dtoToModel(allergyDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(allergyMapper.modelToDto(allergyService.save(allergy)));
    }

    @GetMapping
    public ResponseEntity<List<AllergyDto>>findAll(){

        return ResponseEntity.ok().body(allergyMapper.listModelToDto(allergyService.findAll()));
    }

    @GetMapping("/{idAllergy}")
    public ResponseEntity<AllergyDto>findById(@PathVariable Long idAllergy){

        return ResponseEntity.ok().body(allergyMapper.modelToDto(allergyService.findById(idAllergy)));
    }
}
