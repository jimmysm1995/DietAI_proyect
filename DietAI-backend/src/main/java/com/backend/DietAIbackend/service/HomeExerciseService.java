package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.ImagenProfile;
import com.backend.DietAIbackend.repository.HomeExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeExerciseService {

    @Autowired
    HomeExerciseRepository homeExerciseRepository;


}
