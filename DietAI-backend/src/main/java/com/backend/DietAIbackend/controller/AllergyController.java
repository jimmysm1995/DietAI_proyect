package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.AllergyDto;
import com.backend.DietAIbackend.mapper.AllergyMapper;
import com.backend.DietAIbackend.model.Allergy;
import com.backend.DietAIbackend.service.AllergyService;
import com.backend.DietAIbackend.service.AllergyServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/allergy")
@CrossOrigin(origins = "${cors.allowed.origin}")
@Tag(name = "AllergyController", description = "Endpoint para las alergias")
@Slf4j
public class AllergyController {

    @Autowired
    AllergyService allergyService;

    @Autowired
    AllergyMapper allergyMapper;

    @GetMapping
    @Operation(summary = "Devuelve la lista de las alergias")
    public ResponseEntity<List<AllergyDto>>findAll(){

        return ResponseEntity.ok().body(allergyMapper.listModelToDto(allergyService.findAll()));
    }

}
