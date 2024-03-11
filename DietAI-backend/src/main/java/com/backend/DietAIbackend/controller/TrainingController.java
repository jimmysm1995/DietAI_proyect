package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.ClientDto;
import com.backend.DietAIbackend.dto.GymExerciseDto;
import com.backend.DietAIbackend.dto.TrainingDto;
import com.backend.DietAIbackend.mapper.GymExerciseMapper;
import com.backend.DietAIbackend.mapper.TrainingMapper;
import com.backend.DietAIbackend.model.*;
import com.backend.DietAIbackend.service.TrainingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/trainings")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class TrainingController {

    @Autowired
    TrainingService trainingService;

    @Autowired
    TrainingMapper trainingMapper;

    @Autowired
    GymExerciseMapper gymExerciseMapper;

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
    public ResponseEntity<List<GymExerciseDto>> findExercisesById(@PathVariable Long id){

        List<GymExercise> gymExerciseList = new ArrayList<>();

        Training training = trainingService.findById(id);

        for (TrainingExercise trainingExercise: training.getTrainingExercises()
        ) {
            gymExerciseList.add(trainingExercise.getGymExercise());
        }

        return ResponseEntity.ok().body(gymExerciseMapper.listModelToDto(gymExerciseList));

    }
}
