package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.ExerciseDto;
import com.backend.DietAIbackend.dto.MuscleDto;
import com.backend.DietAIbackend.mapper.ExerciseMapper;
import com.backend.DietAIbackend.mapper.MuscleMapper;
import com.backend.DietAIbackend.model.Exercise;
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

        return ResponseEntity.ok().body(exerciseMapper.listModelToDto(exerciseService.findAll()));
    }

    @GetMapping("/getGymExercises")
    public ResponseEntity<List<ExerciseDto>>findGymExercises(){

        return ResponseEntity.ok().body(exerciseMapper.listModelToDto(exerciseService.findGymExercises()));
    }

    @GetMapping("/getHomeExercises")
    public ResponseEntity<List<ExerciseDto>>findHomeExercises(){

        return ResponseEntity.ok().body(exerciseMapper.listModelToDto(exerciseService.findHomeExercises()));
    }

    @GetMapping("/muscles/{idExercise}")
    public ResponseEntity<List<MuscleDto>> findAllMusclesInExercise(@PathVariable Long idExercise){

        return ResponseEntity.ok().body(muscleMapper.listModelToDto(exerciseService.findAllmusclesInExercise(idExercise)));
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
