package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.HomeExercise;
import com.backend.DietAIbackend.model.ImagenProfile;
import com.backend.DietAIbackend.model.Ingredient;
import com.backend.DietAIbackend.repository.HomeExerciseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeExerciseService {

    @Autowired
    HomeExerciseRepository homeExerciseRepository;

    public HomeExercise save(HomeExercise homeExercise){
        return homeExerciseRepository.save(homeExercise);
    }

    public HomeExercise findById(Long id){
        return homeExerciseRepository.findById(id).orElse(null);
    }

    public List<HomeExercise> findAll(){return homeExerciseRepository.findAll();}
    public void delete(HomeExercise homeExercise){ homeExerciseRepository.delete(homeExercise);}

    public void deleteById(Long id){ homeExerciseRepository.deleteById(id);}

    public HomeExercise update(HomeExercise homeExercise) {
        try {
            homeExerciseRepository.findById(homeExercise.getId());
        } catch (EntityNotFoundException e){
            throw new ServiceException("No existe el cliente en cuestion");
        }

        return homeExerciseRepository.save(homeExercise);
    }


}
