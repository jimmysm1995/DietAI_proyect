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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "ExerciseController", description = "Endpoint para los ejercicios")
public class ExerciseController {

    @Autowired
    ExerciseService exerciseService;

    @Autowired
    ExerciseMapper exerciseMapper;

    @Autowired
    MuscleMapper muscleMapper;

    @PostMapping
    @Operation(summary = "Guarda un ejercicio")
    public ResponseEntity<ExerciseDto> save(@RequestBody ExerciseDto exerciseDto){
            List<Muscle> muscleList = muscleMapper.listDtoToModel(exerciseDto.getMuscle());
            Exercise exercise = exerciseMapper.dtoToModel(exerciseDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(exerciseMapper.modelToDto(exerciseService.save(exercise, muscleList)));
    }


    @GetMapping("/{idExercise}")
    @Operation(summary = "Devuelve un ejercicio según su id")
    public ResponseEntity<ExerciseDto> findById(@PathVariable Long idExercise){
            return ResponseEntity.ok().body(exerciseMapper.modelToDto(exerciseService.findById(idExercise)));
    }

    @GetMapping
    @Operation(summary = "Devuelve todos los ejercicios")
    public ResponseEntity<List<ExerciseDto>>findAll(){
            return ResponseEntity.ok().body(exerciseMapper.listModelToDto(exerciseService.findAll()));
    }

    @GetMapping("/getGymExercises")
    @Operation(summary = "Devuelve todos los ejercicios que se realicen en el gimnasio")
    public ResponseEntity<List<ExerciseDto>>findGymExercises(){
            return ResponseEntity.ok().body(exerciseMapper.listModelToDto(exerciseService.findGymExercises()));
    }

    @GetMapping("/getHomeExercises")
    @Operation(summary = "Devuelve todos los ejercicios que se realicen en la casa")
    public ResponseEntity<List<ExerciseDto>>findHomeExercises(){
            return ResponseEntity.ok().body(exerciseMapper.listModelToDto(exerciseService.findHomeExercises()));
    }

    @GetMapping("/muscles/{idExercise}")
    @Operation(summary = "Devuelve todos los músculos que se realicen en un ejercicio")
    public ResponseEntity<List<MuscleDto>> findAllMusclesInExercise(@PathVariable Long idExercise){
            return ResponseEntity.ok().body(muscleMapper.listModelToDto(exerciseService.findAllmusclesInExercise(idExercise)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un ejercicio por su id")
    public ResponseEntity<Void>deleteTraining(@PathVariable Long id){
        exerciseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
