package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.MuscleDto;
import com.backend.DietAIbackend.exception.ServiceException;
import com.backend.DietAIbackend.mapper.MuscleMapper;
import com.backend.DietAIbackend.service.MuscleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/muscles")
@CrossOrigin(origins = "${cors.allowed.origin}")
@Tag(name = "MuscleController", description = "Endpoint para los músculos de los ejercicios")
@Slf4j
public class MuscleController {

    @Autowired
    MuscleService muscleService;

    @Autowired
    MuscleMapper muscleMapper;

    @GetMapping
    @Operation(summary = "Devuelve una lista con los músculos de los ejercicios")
    public ResponseEntity<?> findAll(){

        try {
            return ResponseEntity.ok().body(muscleMapper.listModelToDto(muscleService.findAll()));
        } catch (ServiceException e){
            return ResponseEntity.status(e.getHttpStatus())
                    .body(e.getMessage());
        }
    }
}
