package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.GymExercise;
import com.backend.DietAIbackend.model.HomeExercise;
import com.backend.DietAIbackend.repository.GymExerciseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymExerciseService {

    @Autowired
    GymExerciseRepository gymExerciseRepository;

    public GymExercise save(GymExercise homeExercise){
        return gymExerciseRepository.save(homeExercise);
    }

    public GymExercise findById(Long id){
        return gymExerciseRepository.findById(id).orElse(null);
    }

    public List<GymExercise> findAll(){return gymExerciseRepository.findAll();}
    public void delete(GymExercise gymExercise){ gymExerciseRepository.delete(gymExercise);}

    public void deleteById(Long id){ gymExerciseRepository.deleteById(id);}

    public GymExercise update(GymExercise gymExercise) {
        try {
            gymExerciseRepository.findById(gymExercise.getIdGymExercise());
        } catch (EntityNotFoundException e){
            throw new ServiceException("No existe el cliente en cuestion");
        }

        return gymExerciseRepository.save(gymExercise);
    }

}
