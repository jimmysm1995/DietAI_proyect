package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Training;
import com.backend.DietAIbackend.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {

    @Autowired
    TrainingRepository entrenamientoRepository;

    public void crearEntrenamiento(Training entrenamiento){
        entrenamientoRepository.save(entrenamiento);
    }

    public void eliminarEntrenamiento(Training entrenamiento){
        entrenamientoRepository.delete(entrenamiento);
    }

    public Training findEntrenamiento(Long id){
        return entrenamientoRepository.findById(id).orElse(null);
    }

    public List<Training> findAllEntrenamientos(){
        return entrenamientoRepository.findAll();
    }
}
