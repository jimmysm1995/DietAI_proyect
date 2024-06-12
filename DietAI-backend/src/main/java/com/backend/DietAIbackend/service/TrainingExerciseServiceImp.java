package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.TrainingExercise;
import com.backend.DietAIbackend.repository.TrainingExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingExerciseServiceImp implements TrainingExerciseService {

    @Autowired
    TrainingExerciseRepository trainingExerciseRepository;

    /**
     * Guarda la relación entre ejercicios y entrenamiento
     *
     * @param trainingExercise
     * @return
     */
    public TrainingExercise save(TrainingExercise trainingExercise){
        return trainingExerciseRepository.save(trainingExercise);
    }

    /**
     * Elimina la relación entre ejercicios y entrenamiento
     *
     * @param trainingExercise
     * @return
     */
    @Override
    public void delete(TrainingExercise trainingExercise) {
        trainingExerciseRepository.delete(trainingExercise);
    }

    /**
     * Devuelve las relaciones que contengan el ejercicio
     *
     * @param idExercicse
     * @return
     */
    @Override
    public List<TrainingExercise> findByExerciseIdExercise(long idExercicse) {
        return trainingExerciseRepository.findByExerciseIdExercise(idExercicse);
    }
}
