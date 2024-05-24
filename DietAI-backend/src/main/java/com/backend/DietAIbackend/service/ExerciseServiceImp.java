package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.exception.ServiceException;
import com.backend.DietAIbackend.model.*;
import com.backend.DietAIbackend.repository.ExerciseRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ExerciseServiceImp implements ExerciseService {

    @Autowired
    ExerciseRepository exerciseRepository;

    @Autowired
    ExerciseMuscleService exerciseMuscleService;

    @Autowired
    TrainingExerciseService trainingExerciseService;

    @Transactional
    @Override
    public Exercise save(Exercise exercise, List<Muscle> muscleList) {
        try {
            Exercise savedExercise = exerciseRepository.save(exercise);
            for (Muscle muscle : muscleList) {
                exerciseMuscleService.save(savedExercise, muscle);
            }
            return savedExercise;
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Ha habido un problema al guardar en la base de datos");
        }
    }


    @Override
    public Exercise findById(Long id){
        return exerciseRepository.findById(id).orElseThrow(
                () -> new ServiceException("No se ha encontrado el ejercicio", HttpStatus.NOT_FOUND)
        );
    }

    @Override
    public Exercise save(Exercise var1) {
        try {
            return exerciseRepository.save(var1);
        } catch (ServiceException e){
            throw new ServiceException("El Ejercicio ya existe en la base de datos", HttpStatus.CONFLICT);
        }
    }

    @Override
    public List<Exercise> findAll() {
        List<Exercise> exercises = exerciseRepository.findAllByOrderByNameAsc();
        if (exercises.isEmpty()) {
            throw new ServiceException("No se encuentran ejercicios", HttpStatus.NOT_FOUND);
        }
        return exercises;
    }

    @Override
    public List<Exercise> findGymExercises() {
        List<Exercise> gymExercises = exerciseRepository.findAll().stream()
                .filter(exercise -> exercise.getTypeTraining().equals(TypeTraining.GIMNASIO))
                .collect(Collectors.toList());

        if (gymExercises.isEmpty()) {
            throw new ServiceException("No se encuentran ejercicios", HttpStatus.NOT_FOUND);
        }
        return gymExercises;
    }

    @Override
    public List<Exercise> findHomeExercises() {
        List<Exercise> homeExercises = exerciseRepository.findAll().stream()
                .filter(exercise -> exercise.getTypeTraining().equals(TypeTraining.CASA))
                .collect(Collectors.toList());

        if (homeExercises.isEmpty()) {
            throw new ServiceException("No se encuentran ejercicios", HttpStatus.NOT_FOUND);
        }
        return homeExercises;
    }

    @Override
    public List<Muscle> findAllmusclesInExercise(Long id) {

        Exercise exercise = findById(id);
        List<Muscle> muscleList = new ArrayList<>();
        for (ExerciseMuscle exerciseMuscle: exercise.getExerciseMuscles()
        ) {
            muscleList.add(exerciseMuscle.getMuscle());
        }
        if (muscleList.isEmpty()){
            throw new ServiceException("No hay musculos relacionados", HttpStatus.NOT_FOUND);
        }
        return muscleList;
    }

    @Override
    public void deleteById(Long id) {
        // Verificar si el ejercicio existe
        Exercise exercise = findById(id);

        // Eliminar manualmente los registros en training_exercise relacionados con este ejercicio
        List<TrainingExercise> trainingExercises = trainingExerciseService.findByExerciseIdExercise(id);
        for (TrainingExercise trainingExercise : trainingExercises) {
            trainingExerciseService.delete(trainingExercise);
        }

        // Finalmente, eliminar el ejercicio
        exerciseRepository.delete(exercise);
    }

    @Override
    public Exercise update(Exercise exercise) {
        findById(exercise.getIdExercise());
        return exerciseRepository.save(exercise);
    }
}
