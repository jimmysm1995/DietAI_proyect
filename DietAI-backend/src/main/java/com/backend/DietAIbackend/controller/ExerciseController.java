package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.ExerciseDto;
import com.backend.DietAIbackend.mapper.ExerciseMapper;
import com.backend.DietAIbackend.model.Exercise;
import com.backend.DietAIbackend.model.ExerciseMuscle;
import com.backend.DietAIbackend.service.ExerciseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/homeExercises")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class ExerciseController {

    @Autowired
    ExerciseService exerciseService;

    @Autowired
    ExerciseMapper exerciseMapper;


    @GetMapping("/{idExercise}")
    public ResponseEntity<ExerciseDto> findClientById(@PathVariable Long idExercise){
        return ResponseEntity.status(HttpStatus.CREATED).body(exerciseMapper.modelToDto(exerciseService.findById(idExercise)));
    }

    @GetMapping
    public ResponseEntity<List<ExerciseDto>>findAllExercise(){
        List<Exercise> exercises = exerciseService.findAll();
        List<ExerciseDto> exerciseDtoList = exerciseMapper.listModelToDto(exercises);
        return ResponseEntity.ok().body(exerciseDtoList);
    }

    @GetMapping("/muscles/{idExercise}")
    public ResponseEntity<List<String>> findAllmusclesInExercise(@PathVariable Long idExercise){

        Exercise exercise = exerciseService.findById(idExercise);

        List<String> muscleList = new ArrayList<>();

        for (ExerciseMuscle exerciseMuscle: exercise.getExerciseMuscles()
             ) {
            muscleList.add(exerciseMuscle.getMuscle().getName());
        }

        return ResponseEntity.ok().body(muscleList);
    }
}
