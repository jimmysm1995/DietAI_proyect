package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Allergy;
import com.backend.DietAIbackend.model.Exercise;
import com.backend.DietAIbackend.model.ExerciseMuscle;
import com.backend.DietAIbackend.model.Muscle;
import com.backend.DietAIbackend.repository.ExerciseRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    ExerciseRepository exerciseRepository;

    @Autowired
    ExerciseMuscleService exerciseMuscleService;


    @Transactional
    public Exercise save(Exercise exercise, List<Muscle> muscleList){

        for (Muscle muscle : muscleList) {
            exerciseMuscleService.save(exercise,muscle);
        }

        return exerciseRepository.save(exercise);
    }

    public Exercise findById(Long id){
        return exerciseRepository.findById(id).orElse(null);
    }

    public List<Exercise> findAll(){return exerciseRepository.findAll();}
    public void delete(Exercise exercise){ exerciseRepository.delete(exercise);}

    public void deleteById(Long id){ exerciseRepository.deleteById(id);}

    public Exercise update(Exercise exercise) {
        try {
            exerciseRepository.findById(exercise.getIdExercise());
        } catch (EntityNotFoundException e){
            throw new ServiceException("No existe el ejercicio en cuestion");
        }

        return exerciseRepository.save(exercise);
    }
}
