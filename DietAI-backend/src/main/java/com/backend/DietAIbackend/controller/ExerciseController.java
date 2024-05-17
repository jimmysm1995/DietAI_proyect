package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.ExerciseDto;
import com.backend.DietAIbackend.dto.MuscleDto;
import com.backend.DietAIbackend.exception.ServiceException;
import com.backend.DietAIbackend.mapper.ExerciseMapper;
import com.backend.DietAIbackend.mapper.MuscleMapper;
import com.backend.DietAIbackend.model.Exercise;
import com.backend.DietAIbackend.model.Ingredient;
import com.backend.DietAIbackend.model.Muscle;
import com.backend.DietAIbackend.service.ExerciseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> save(@RequestBody ExerciseDto exerciseDto){
        try {
            List<Muscle> muscleList = muscleMapper.listDtoToModel(exerciseDto.getMuscle());
            Exercise exercise = exerciseMapper.dtoToModel(exerciseDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(exerciseMapper.modelToDto(exerciseService.save(exercise, muscleList)));
        } catch (ServiceException e) {
            return ResponseEntity.status(e.getHttpStatus())
                    .body(e.getMessage());
        }
    }


    @GetMapping("/{idExercise}")
    public ResponseEntity<?> findClientById(@PathVariable Long idExercise){
        try {
            return ResponseEntity.ok().body(exerciseMapper.modelToDto(exerciseService.findById(idExercise)));
        }catch (ServiceException e) {
            return ResponseEntity.status(e.getHttpStatus())
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?>findAllExercise(){
        try {
            return ResponseEntity.ok().body(exerciseMapper.listModelToDto(exerciseService.findAll()));
        }catch (ServiceException e) {
            return ResponseEntity.status(e.getHttpStatus())
                    .body(e.getMessage());
        }
    }

    @GetMapping("/getGymExercises")
    public ResponseEntity<?>findGymExercises(){

        try {
            return ResponseEntity.ok().body(exerciseMapper.listModelToDto(exerciseService.findGymExercises()));
        }catch (ServiceException e) {
            return ResponseEntity.status(e.getHttpStatus())
                    .body(e.getMessage());
        }

    }

    @GetMapping("/getHomeExercises")
    public ResponseEntity<?>findHomeExercises(){
        try {
            return ResponseEntity.ok().body(exerciseMapper.listModelToDto(exerciseService.findHomeExercises()));
        }catch (ServiceException e) {
            return ResponseEntity.status(e.getHttpStatus())
                    .body(e.getMessage());
        }

    }

    @GetMapping("/muscles/{idExercise}")
    public ResponseEntity<?> findAllMusclesInExercise(@PathVariable Long idExercise){
        try {
            return ResponseEntity.ok().body(muscleMapper.listModelToDto(exerciseService.findAllmusclesInExercise(idExercise)));
        }catch (ServiceException e) {
            return ResponseEntity.status(e.getHttpStatus())
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteTraining(@PathVariable Long id){
        try {
            exerciseService.deleteById(id);
        } catch (Exception e){
            log.error("Ha habido un problema al borrar el ejercicio");
        }
        return ResponseEntity.noContent().build();
    }
}
