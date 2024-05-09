package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Exercise;
import com.backend.DietAIbackend.model.ExerciseMuscle;
import com.backend.DietAIbackend.model.Muscle;
import com.backend.DietAIbackend.model.TypeTraining;
import com.backend.DietAIbackend.repository.ExerciseRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ExerciseServiceImp implements ExerciseService {

    @Autowired
    ExerciseRepository exerciseRepository;

    @Autowired
    ExerciseMuscleService exerciseMuscleService;

    @Transactional
    @Override
    public Exercise save(Exercise exercise, List<Muscle> muscleList){

        Exercise saveExercise = exerciseRepository.save(exercise);

        for (Muscle muscle : muscleList) {
            exerciseMuscleService.save(exercise, muscle);
        }

        return saveExercise;
    }

    @Override
    public Exercise findById(Long id){
        return exerciseRepository.findById(id).orElse(null);
    }

    @Override
    public Exercise save(Exercise var1) {
        return exerciseRepository.save(var1);
    }

    @Override
    public List<Exercise> findAll(){return exerciseRepository.findAll();}

    @Override
    public List<Exercise> findGymExercises(){

        List<Exercise> gymExercises = new ArrayList<>();

        for (Exercise exercise : exerciseRepository.findAll()) {
            if (exercise.getTypeTraining().equals(TypeTraining.GIMNASIO)){
                gymExercises.add(exercise);
            }
        }

        return gymExercises;
    }

    @Override
    public List<Muscle> findAllmusclesInExercise(Long id) {

        Exercise exercise = findById(id);

        List<Muscle> muscleList = new ArrayList<>();

        for (ExerciseMuscle exerciseMuscle: exercise.getExerciseMuscles()
        ) {
            muscleList.add(exerciseMuscle.getMuscle());
        }

        return muscleList;
    }

    @Override
    public List<Exercise> findHomeExercises(){

        List<Exercise> homeExercises = new ArrayList<>();

        for (Exercise exercise : exerciseRepository.findAll()) {
            if (exercise.getTypeTraining().equals(TypeTraining.CASA)){
                homeExercises.add(exercise);
            }
        }

        return homeExercises;
    }

    @Override
    public void deleteById(Long id){ exerciseRepository.deleteById(id);}

    @Override
    public Exercise update(Exercise exercise) {
        try {
            exerciseRepository.findById(exercise.getIdExercise());
        } catch (EntityNotFoundException e){
            throw new ServiceException("No existe el ejercicio en cuestion");
        }

        return exerciseRepository.save(exercise);
    }
}
