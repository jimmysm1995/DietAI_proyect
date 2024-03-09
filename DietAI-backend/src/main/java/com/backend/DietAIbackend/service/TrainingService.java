package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Recipe;
import com.backend.DietAIbackend.model.Training;
import com.backend.DietAIbackend.repository.TrainingRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {

    @Autowired
    TrainingRepository trainingRepository;

    public void save(Training training){
        trainingRepository.save(training);
    }

    public void delete(Training training){
        trainingRepository.delete(training);
    }

    public Training findById(Long id){
        return trainingRepository.findById(id).orElse(null);
    }

    public List<Training> findAll(){
        return trainingRepository.findAll();
    }

    public Training update(Training training) {
        try {
            trainingRepository.findById(training.getIdTraining());
        } catch (EntityNotFoundException e){
            throw new ServiceException("No existe el cliente en cuestion");
        }
        return trainingRepository.save(training);
    }
}
