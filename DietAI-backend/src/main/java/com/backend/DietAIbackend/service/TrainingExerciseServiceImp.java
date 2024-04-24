package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.TrainingExercise;
import com.backend.DietAIbackend.repository.TrainingExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingExerciseServiceImp implements TrainingExerciseService {

    @Autowired
    TrainingExerciseRepository trainingExerciseRepository;

    public TrainingExercise save(TrainingExercise trainingExercise){
        return trainingExerciseRepository.save(trainingExercise);
    }
}
