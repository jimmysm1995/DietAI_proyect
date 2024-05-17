package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.exception.ServiceException;
import com.backend.DietAIbackend.model.Muscle;
import com.backend.DietAIbackend.repository.MuscleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuscleServiceImp implements MuscleService {

    @Autowired
    MuscleRepository muscleRepository;

    public List<Muscle> findAll(){
        if (muscleRepository.findAll().isEmpty()){
            throw new ServiceException("No se encuentran musculos en la lista", HttpStatus.NOT_FOUND.value());
        }
        return muscleRepository.findAll();
    }
}
