package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.dto.ExercisesInTraining;
import com.backend.DietAIbackend.model.*;
import com.backend.DietAIbackend.repository.TrainingRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TrainingService {

    @Autowired
    TrainingRepository trainingRepository;

    @Autowired
    TrainingExerciseService trainingExerciseService;

    public Training save(Training training, List<ExercisesInTraining> exercisesInTrainingList){

        Training entrenamiento = trainingRepository.save(training);

        for (ExercisesInTraining exercisesInTraining: exercisesInTrainingList
             ) {
            if (exercisesInTraining != null){
                TrainingExercise trainingExercise = new TrainingExercise();
                trainingExercise.setTraining(training);
                trainingExercise.setExercise(exercisesInTraining.exercise());
                trainingExercise.setSets(exercisesInTraining.sets());
                trainingExercise.setReps(exercisesInTraining.reps());
                trainingExercise.setOrderDay(exercisesInTraining.orderDay());
                trainingExercise.setOrderWeek(exercisesInTraining.orderWeek());
                trainingExerciseService.save(trainingExercise);
            }
        }

        return entrenamiento;
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

    public List<ExercisesInTraining> findExercisesById(Long id) {

        Training training = trainingRepository.findById(id).orElse(null);

        List<ExercisesInTraining> exercisesInTrainings = new ArrayList<>();

        for (TrainingExercise trainingExercise: training.getTrainingExercises()
        ) {
            exercisesInTrainings.add(new ExercisesInTraining(
                    trainingExercise.getExercise(),
                    trainingExercise.getSets(),
                    trainingExercise.getReps(),
                    trainingExercise.getOrderDay(),
                    trainingExercise.getOrderWeek()
            ));
        }

        return exercisesInTrainings;
    }


}
