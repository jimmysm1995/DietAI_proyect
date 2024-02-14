package com.dietai.dietai.service;

import com.dietai.dietai.repository.HomeExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeExerciseService {

    @Autowired
    HomeExerciseRepository homeExerciseRepository;
}
