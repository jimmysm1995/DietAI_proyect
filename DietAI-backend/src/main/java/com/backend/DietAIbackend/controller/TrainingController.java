package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.*;
import com.backend.DietAIbackend.mapper.ExerciseMapper;
import com.backend.DietAIbackend.mapper.TrainingMapper;
import com.backend.DietAIbackend.model.*;
import com.backend.DietAIbackend.service.TrainingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainings")
@CrossOrigin(origins = "${cors.allowed.origin}")
@Slf4j
public class TrainingController {

    @Autowired
    TrainingService trainingService;

    @Autowired
    TrainingMapper trainingMapper;
    @Autowired
    ExerciseMapper exerciseMapper;

    @GetMapping("/{id}")
    public ResponseEntity<TrainingDto> findTrainingById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(trainingMapper.modelToDto(trainingService.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<TrainingDto>>findAllTraining(){

        List<Training> trainingList = trainingService.findAll();
        List<TrainingDto> trainingDtoList = trainingMapper.listModelToDto(trainingList);
        return ResponseEntity.ok().body(trainingDtoList);
    }

    @GetMapping("/exercises/{id}")
    public ResponseEntity<List<ExercisesInTraining>> findExercisesById(@PathVariable Long id){

        List<ExercisesInTraining> exerciseList = trainingService.findExercisesById(id);

        return ResponseEntity.ok().body(exerciseList);
    }

    @PostMapping
    public ResponseEntity<TrainingDto> save(@RequestBody TrainingWithExercisesRequest request){

        Training training = trainingMapper.dtoToModel(request.getTraining());

        List<ExercisesInTraining> exercisesInTrainingList = request.getExercisesInTraining();

        return ResponseEntity.ok().body(trainingMapper.modelToDto(trainingService.save(training, exercisesInTrainingList)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteTraining(@PathVariable Long id){
        try {
            trainingService.deleteById(id);
        } catch (Exception e){
            log.error("Ha habido un problema al borrar el entrenamiento");
        }
        return ResponseEntity.noContent().build();
    }

}
