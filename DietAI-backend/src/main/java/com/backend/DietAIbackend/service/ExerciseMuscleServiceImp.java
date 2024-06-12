package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.*;
import com.backend.DietAIbackend.repository.ExerciseMuscleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseMuscleServiceImp implements ExerciseMuscleService {

    @Autowired
    ExerciseMuscleRepository exerciseMuscleRepository;

    /**
     * Guarda la relacion entre los ejercicios y los musculos
     *
     * @param exercise
     * @param muscle
     * @return
     */
    public ExerciseMuscle save(Exercise exercise, Muscle muscle){

        try {
            ExerciseMuscle exerciseMuscle = ExerciseMuscle.builder()
                    .exercise(exercise)
                    .muscle(muscle)
                    .build();

            return exerciseMuscleRepository.save(exerciseMuscle);
        } catch (Exception e){
            throw e;
        }

    }
}
