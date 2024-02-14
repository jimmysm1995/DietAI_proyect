package com.dietai.dietai.service;

import com.dietai.dietai.repository.GymExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GymExerciseService {

    @Autowired
    GymExerciseRepository gymExerciseRepository;

}
