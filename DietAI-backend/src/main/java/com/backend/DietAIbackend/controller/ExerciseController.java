package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.ExerciseDto;
import com.backend.DietAIbackend.mapper.ExerciseMapper;
import com.backend.DietAIbackend.mapper.MuscleMapper;
import com.backend.DietAIbackend.model.Exercise;
import com.backend.DietAIbackend.model.ExerciseMuscle;
import com.backend.DietAIbackend.model.Muscle;
import com.backend.DietAIbackend.service.ExerciseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/exercises")
@CrossOrigin(origins = "${cors.allowed.origin}")
@Slf4j
public class ExerciseController {

    @Autowired
    ExerciseService exerciseService;

    @Autowired
    ExerciseMapper exerciseMapper;

    @Autowired
    MuscleMapper muscleMapper;

    @PostMapping
    public ResponseEntity<ExerciseDto> save(@RequestBody ExerciseDto exerciseDto){

        List<Muscle> muscleList = muscleMapper.listDtoToModel(exerciseDto.getMuscle());

        Exercise exercise = exerciseMapper.dtoToModel(exerciseDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(exerciseMapper.modelToDto(exerciseService.save(exercise, muscleList)));


    }


    @GetMapping("/{idExercise}")
    public ResponseEntity<ExerciseDto> findClientById(@PathVariable Long idExercise){
        return ResponseEntity.status(HttpStatus.CREATED).body(exerciseMapper.modelToDto(exerciseService.findById(idExercise)));
    }

    @GetMapping
    public ResponseEntity<List<ExerciseDto>>findAllExercise(){

        List<Exercise> exercises = exerciseService.findAll();

        return ResponseEntity.ok().body(exerciseMapper.listModelToDto(exercises));
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
