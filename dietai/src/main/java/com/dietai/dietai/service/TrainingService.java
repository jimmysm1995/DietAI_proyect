package com.dietai.dietai.service;

import com.dietai.dietai.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {

    @Autowired
    TrainingRepository entrenamientoRepository;

}
