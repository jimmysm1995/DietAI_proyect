package com.dietai.dietai.service;


import com.dietai.dietai.repository.TrainingExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingExerciseService {

    @Autowired
    TrainingExerciseRepository trainingExerciseRepository;
}
