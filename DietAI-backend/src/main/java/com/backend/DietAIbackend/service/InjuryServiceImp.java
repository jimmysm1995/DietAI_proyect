package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Injury;
import com.backend.DietAIbackend.repository.InjuryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InjuryServiceImp implements InjuryService {

    @Autowired
    InjuryRepository injuryRepository;

    /**
     * Devuelve todas las lesiones
     *
     * @return
     */
    public List<Injury> findAll(){return injuryRepository.findAll();}

}
