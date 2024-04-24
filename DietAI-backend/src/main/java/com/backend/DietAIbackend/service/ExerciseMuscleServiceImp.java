package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.*;
import com.backend.DietAIbackend.repository.ExerciseMuscleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseMuscleServiceImp implements ExerciseMuscleService {

    @Autowired
    ExerciseMuscleRepository exerciseMuscleRepository;

    public ExerciseMuscle save(Exercise exercise, Muscle muscle){

        ExerciseMuscle exerciseMuscle = new ExerciseMuscle();

        exerciseMuscle.setExercise(exercise);
        exerciseMuscle.setMuscle(muscle);

        return exerciseMuscleRepository.save(exerciseMuscle);
    }
}
