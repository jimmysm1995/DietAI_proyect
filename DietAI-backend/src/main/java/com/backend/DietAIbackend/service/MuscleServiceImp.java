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

    /**
     * Devuelve una lista con todos los musculos
     *
      * @return
     */
    public List<Muscle> findAll(){
        if (muscleRepository.findAllByOrderByNameAsc().isEmpty()){
            throw new ServiceException("No se encuentran musculos", HttpStatus.NOT_FOUND);
        }
        return muscleRepository.findAll();
    }
}
