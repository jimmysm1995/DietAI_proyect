package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.dto.ExercisesInTraining;
import com.backend.DietAIbackend.exception.ServiceException;
import com.backend.DietAIbackend.model.*;
import com.backend.DietAIbackend.repository.TrainingRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TrainingServiceImp implements TrainingService {

    @Autowired
    TrainingRepository trainingRepository;

    @Autowired
    TrainingExerciseService trainingExerciseService;

    public Training save(Training training, List<ExercisesInTraining> exercisesInTrainingList){

        Training entrenamiento = new Training();

        try {
            entrenamiento = trainingRepository.save(training);
        } catch (ServiceException e) {
            throw new ServiceException("El entrenamiento ya existe en la base de datos", HttpStatus.CONFLICT.value());
        }

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

    public void deleteById(Long id){
        trainingRepository.deleteById(id);
    }

    public Training findById(Long id){
        return trainingRepository.findById(id).orElseThrow(
                () -> new ServiceException("No se ha encontrado el entrenamiento", HttpStatus.NOT_FOUND.value())
        );
    }

    @Override
    public Training save(Training var1) {
        return trainingRepository.save(var1);
    }

    public List<Training> findAll(){
        if (trainingRepository.findAllByOrderByNameAsc().isEmpty()){
            throw new ServiceException("La lista esta vacia", HttpStatus.NOT_FOUND.value());
        }
        return trainingRepository.findAllByOrderByNameAsc();
    }

    public Training update(Training training) {
        try {
            trainingRepository.findById(training.getIdTraining());
        } catch (ServiceException e){
            throw new ServiceException("No existe el entrenamiento en cuestion", HttpStatus.NOT_FOUND.value());
        }
        return save(training);
    }

    public List<ExercisesInTraining> findExercisesById(Long id) {

        Training training = findById(id);

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

        if (exercisesInTrainings.isEmpty()){
            throw new ServiceException("La lista esta vacia", HttpStatus.NOT_FOUND.value());
        }

        return exercisesInTrainings;
    }


}
