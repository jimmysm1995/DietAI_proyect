package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Entrenamiento;
import com.backend.DietAIbackend.model.Receta;
import com.backend.DietAIbackend.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecetaService {

    @Autowired
    RecetaRepository recetaRepository;

    public void crearReceta(Receta receta){
        recetaRepository.save(receta);
    }

    public void eliminarReceta(Receta receta){
        recetaRepository.delete(receta);
    }

    public Receta findReceta(Long id){
        return recetaRepository.findById(id).orElse(null);
    }

    public List<Receta> findAllReceta(){
        return recetaRepository.findAll();
    }
}
