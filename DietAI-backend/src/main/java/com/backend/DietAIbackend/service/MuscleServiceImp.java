package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Muscle;
import com.backend.DietAIbackend.repository.MuscleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuscleServiceImp implements MuscleService {

    @Autowired
    MuscleRepository muscleRepository;

    public List<Muscle> findAll(){
        return muscleRepository.findAll();
    }

}
