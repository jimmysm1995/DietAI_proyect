package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.repository.GymExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GymExerciseService {

    @Autowired
    GymExerciseRepository gymExerciseRepository;

}
