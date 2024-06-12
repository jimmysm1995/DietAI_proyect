package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.*;
import com.backend.DietAIbackend.exception.ServiceException;
import com.backend.DietAIbackend.mapper.ExerciseMapper;
import com.backend.DietAIbackend.mapper.TrainingMapper;
import com.backend.DietAIbackend.model.*;
import com.backend.DietAIbackend.service.TrainingService;
import com.backend.DietAIbackend.service.TrainingServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainings")
@CrossOrigin(origins = "${cors.allowed.origin}")
@Tag(name = "TrainingController", description = "Endpoint para los entrenamientos")
@Slf4j
public class TrainingController {

    @Autowired
    TrainingService trainingService;

    @Autowired
    TrainingMapper trainingMapper;
    @Autowired
    ExerciseMapper exerciseMapper;

    @GetMapping("/{id}")
    @Operation(summary = "Devuelve un entrenamiento según su id")
    public ResponseEntity<TrainingDto> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(trainingMapper.modelToDto(trainingService.findById(id)));
    }

    @GetMapping
    @Operation(summary = "Devuelve una lista con todos los entrenamientos")
    public ResponseEntity<List<TrainingDto>>findAll(){

            List<Training> trainingList = trainingService.findAll();
            List<TrainingDto> trainingDtoList = trainingMapper.listModelToDto(trainingList);
            return ResponseEntity.ok().body(trainingDtoList);


    }

    @GetMapping("/exercises/{id}")
    @Operation(summary = "Devuelve una lista con todos los ejercicios en un entrenamiento junto al orden, series y repeticiones")
    public ResponseEntity<List<ExercisesInTraining>> findExercisesById(@PathVariable Long id){

        return ResponseEntity.ok().body(trainingService.findExercisesById(id));
    }

    @PostMapping
    @Operation(summary = "Guarda un entrenamiento")
    public ResponseEntity<TrainingDto> save(@RequestBody TrainingWithExercisesRequest request){

            Training training = trainingMapper.dtoToModel(request.getTraining());

            List<ExercisesInTraining> exercisesInTrainingList = request.getExercisesInTraining();

            return ResponseEntity.ok().body(trainingMapper.modelToDto(trainingService.save(training, exercisesInTrainingList)));

        }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un entrenamiento")
    public ResponseEntity<Void>deleteTraining(@PathVariable Long id){
            trainingService.deleteById(id);
            return ResponseEntity.noContent().build();
    }

}
