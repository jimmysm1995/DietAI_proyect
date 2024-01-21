package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Dieta;
import com.backend.DietAIbackend.repository.DietaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DietaService {

    @Autowired
    DietaRepository dietaRepository;

    public void crearDieta(Dieta dieta){
        dietaRepository.save(dieta);
    }

    public void eliminarDieta(Dieta dieta){
        dietaRepository.delete(dieta);
    }

    public Dieta findDieta(Long id){
        return dietaRepository.findById(id).orElse(null);
    }

    public List<Dieta> findAllDietas(){
        return dietaRepository.findAll();
    }



}
