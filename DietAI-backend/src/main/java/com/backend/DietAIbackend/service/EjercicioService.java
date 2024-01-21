package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Ejercicio;
import com.backend.DietAIbackend.model.Receta;
import com.backend.DietAIbackend.repository.EjercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjercicioService {

    @Autowired
    EjercicioRepository ejercicioRepository;

    public void crearEjercicio(Ejercicio ejercicio){
        ejercicioRepository.save(ejercicio);
    }

    public void eliminarEjercicio(Ejercicio ejercicio){
        ejercicioRepository.delete(ejercicio);
    }

    public Ejercicio findEjercicio(Long id){
        return ejercicioRepository.findById(id).orElse(null);
    }

    public List<Ejercicio> findAllEjercicio(){
        return ejercicioRepository.findAll();
    }
}
