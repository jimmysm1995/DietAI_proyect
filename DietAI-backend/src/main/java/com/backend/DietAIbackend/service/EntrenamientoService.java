package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Dieta;
import com.backend.DietAIbackend.model.Entrenamiento;
import com.backend.DietAIbackend.repository.EntrenamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenamientoService {

    @Autowired
    EntrenamientoRepository entrenamientoRepository;

    public void crearEntrenamiento(Entrenamiento entrenamiento){
        entrenamientoRepository.save(entrenamiento);
    }

    public void eliminarEntrenamiento(Entrenamiento entrenamiento){
        entrenamientoRepository.delete(entrenamiento);
    }

    public Entrenamiento findEntrenamiento(Long id){
        return entrenamientoRepository.findById(id).orElse(null);
    }

    public List<Entrenamiento> findAllEntrenamientos(){
        return entrenamientoRepository.findAll();
    }
}
