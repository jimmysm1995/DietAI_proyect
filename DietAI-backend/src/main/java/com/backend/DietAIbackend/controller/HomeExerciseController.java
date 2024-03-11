package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.ClientDto;
import com.backend.DietAIbackend.dto.HomeExerciseDto;
import com.backend.DietAIbackend.dto.MuscleDto;
import com.backend.DietAIbackend.mapper.HomeExerciseMapper;
import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.model.HomeExercise;
import com.backend.DietAIbackend.model.HomeExerciseMuscle;
import com.backend.DietAIbackend.model.Muscle;
import com.backend.DietAIbackend.service.HomeExerciseService;
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
public class HomeExerciseController {

    @Autowired
    HomeExerciseService homeExerciseService;

    @Autowired
    HomeExerciseMapper homeExerciseMapper;


    @GetMapping("/{idHomeExercise}")
    public ResponseEntity<HomeExerciseDto> findClientById(@PathVariable Long idHomeExercise){
        return ResponseEntity.status(HttpStatus.CREATED).body(homeExerciseMapper.modelToDto(homeExerciseService.findById(idHomeExercise)));
    }

    @GetMapping
    public ResponseEntity<List<HomeExerciseDto>>findAllHomeExercise(){
        List<HomeExercise> homeExercises = homeExerciseService.findAll();
        List<HomeExerciseDto> homeExerciseDtoList = homeExerciseMapper.listModelToDto(homeExercises);
        return ResponseEntity.ok().body(homeExerciseDtoList);
    }

    @GetMapping("/muscles/{idHomeExercise}")
    public ResponseEntity<List<String>> findAllmusclesInExercise(@PathVariable Long idHomeExercise){

        HomeExercise homeExercise = homeExerciseService.findById(idHomeExercise);

        List<String> muscleList = new ArrayList<>();

        for (HomeExerciseMuscle home: homeExercise.getHomeExerciseMuscles()
             ) {
            muscleList.add(home.getMuscle().getName());
        }

        return ResponseEntity.ok().body(muscleList);
    }
}
