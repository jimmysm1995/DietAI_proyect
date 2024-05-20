package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.*;
import com.backend.DietAIbackend.exception.ServiceException;
import com.backend.DietAIbackend.mapper.ExerciseMapper;
import com.backend.DietAIbackend.mapper.TrainingMapper;
import com.backend.DietAIbackend.model.*;
import com.backend.DietAIbackend.service.TrainingService;
import com.backend.DietAIbackend.service.TrainingServiceImp;
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
    public ResponseEntity<?> findTrainingById(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(trainingMapper.modelToDto(trainingService.findById(id)));
        } catch (ServiceException e){
            return ResponseEntity.status(e.getHttpStatus())
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?>findAllTraining(){

        try{
            List<Training> trainingList = trainingService.findAll();
            List<TrainingDto> trainingDtoList = trainingMapper.listModelToDto(trainingList);
            return ResponseEntity.ok().body(trainingDtoList);
        }catch (ServiceException e){
            return ResponseEntity.status(e.getHttpStatus())
                    .body(e.getMessage());
        }


    }

    @GetMapping("/exercises/{id}")
    public ResponseEntity<?> findExercisesById(@PathVariable Long id){

        try {
            return ResponseEntity.ok().body(trainingService.findExercisesById(id));
        } catch (ServiceException e){
            return ResponseEntity.status(e.getHttpStatus())
                    .body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody TrainingWithExercisesRequest request){

        try {
            Training training = trainingMapper.dtoToModel(request.getTraining());

            List<ExercisesInTraining> exercisesInTrainingList = request.getExercisesInTraining();

            return ResponseEntity.ok().body(trainingMapper.modelToDto(trainingService.save(training, exercisesInTrainingList)));
        } catch (ServiceException e){
            return ResponseEntity.status(e.getHttpStatus())
                    .body(e.getMessage());
        }

        }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteTraining(@PathVariable Long id){
        try {
            trainingService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (ServiceException e){
            return ResponseEntity.status(e.getHttpStatus())
                    .body(e.getMessage());
        }
    }

}
