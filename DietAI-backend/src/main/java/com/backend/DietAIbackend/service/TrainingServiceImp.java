package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.dto.ExercisesInTraining;
import com.backend.DietAIbackend.exception.ServiceException;
import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.model.Training;
import com.backend.DietAIbackend.model.TrainingExercise;
import com.backend.DietAIbackend.repository.TrainingRepository;
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

    @Autowired
    private ClientService clientService;

    public Training save(Training training, List<ExercisesInTraining> exercisesInTrainingList) {

        Training entrenamiento;

        try {
            entrenamiento = trainingRepository.save(training);
        } catch (ServiceException e) {
            throw new ServiceException("El entrenamiento ya existe en la base de datos", HttpStatus.CONFLICT);
        }

        for (ExercisesInTraining exercisesInTraining : exercisesInTrainingList
        ) {
            if (exercisesInTraining != null) {
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

    public void deleteById(Long id) {

        try {
            if (!trainingRepository.existsById(id)) {
                throw new ServiceException("No se encontró el entrenamiento para eliminar", HttpStatus.NOT_FOUND);
            }

            // Disociar los clients
            for (Client client : findById(id).getClients()) {
                client.setTraining(null);
                clientService.save(client);
            }

            trainingRepository.deleteById(id);
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            log.error("Error al eliminar el entrenamiento: ", e);
            throw new ServiceException("Ocurrió un error al eliminar la dieta " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Training findById(Long id) {
        return trainingRepository.findById(id).orElseThrow(
                () -> new ServiceException("No se ha encontrado el entrenamiento", HttpStatus.NOT_FOUND)
        );
    }

    @Override
    public Training save(Training var1) {
        return trainingRepository.save(var1);
    }

    public List<Training> findAll() {
        if (trainingRepository.findAllByOrderByNameAsc().isEmpty()) {
            throw new ServiceException("No se encuentran Entrenamientos", HttpStatus.NOT_FOUND);
        }
        return trainingRepository.findAllByOrderByNameAsc();
    }

    public Training update(Training training) {
        findById(training.getIdTraining());
        return save(training);
    }

    public List<ExercisesInTraining> findExercisesById(Long id) {

        Training training = findById(id);

        List<ExercisesInTraining> exercisesInTrainings = new ArrayList<>();

        for (TrainingExercise trainingExercise : training.getTrainingExercises()
        ) {
            exercisesInTrainings.add(new ExercisesInTraining(
                    trainingExercise.getExercise(),
                    trainingExercise.getSets(),
                    trainingExercise.getReps(),
                    trainingExercise.getOrderDay(),
                    trainingExercise.getOrderWeek()
            ));
        }

        if (exercisesInTrainings.isEmpty()) {
            throw new ServiceException("La lista esta vacia", HttpStatus.NOT_FOUND);
        }

        return exercisesInTrainings;
    }
}
