package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Allergy;
import com.backend.DietAIbackend.repository.AllergyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllergyServiceImp implements AllergyService {

    @Autowired
    AllergyRepository allergyRepository;

    /**
     *
     * Devuelve todas las alergias
     *
     * @return List<Allergy>
     */
    public List<Allergy> findAll(){return allergyRepository.findAll();}
}
