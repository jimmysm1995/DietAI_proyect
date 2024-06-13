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

    /**
     * Guarda el entrenamiento
     *
     * @param training
     * @param exercisesInTrainingList
     * @return
     */
    public Training save(Training training, List<ExercisesInTraining> exercisesInTrainingList) {


        try {
            trainingRepository.save(training);

            for (ExercisesInTraining exercisesInTraining : exercisesInTrainingList
            ) {
                if (exercisesInTraining != null) {
                    TrainingExercise trainingExercise = TrainingExercise.builder()
                            .training(training)
                            .exercise(exercisesInTraining.exercise())
                            .sets(exercisesInTraining.sets())
                            .reps(exercisesInTraining.reps())
                            .orderDay(exercisesInTraining.orderDay())
                            .orderWeek(exercisesInTraining.orderWeek())
                            .build();
                    trainingExerciseService.save(trainingExercise);
                }
            }

            return training;
        } catch (Exception e) {
            throw new ServiceException("Ocurrió un error al guardar el entrenamiento", HttpStatus.BAD_REQUEST);
        }


    }

    /**
     * Elimina por el id
     *
     * @param id
     */
    public void deleteById(Long id) {

        try {
            if (!trainingRepository.existsById(id)) {
                throw new ServiceException("No se encontró el entrenamiento para eliminar", HttpStatus.NOT_FOUND);
            }

            // Disociar los clients
            for (Client client : findById(id).getClients()) {
                client.setTraining(null);
                clientService.update(client);
            }

            trainingRepository.deleteById(id);
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            log.error("Error al eliminar el entrenamiento: ", e);
            throw new ServiceException("Ocurrió un error al eliminar la dieta " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Encuentra por el id
     *
     * @param id
     * @return
     */
    public Training findById(Long id) {
        return trainingRepository.findById(id).orElseThrow(
                () -> new ServiceException("No se ha encontrado el entrenamiento", HttpStatus.NOT_FOUND)
        );
    }


    /**
     * Devuelve una lista con todos los entrenamientos
     *
     * @return
     */
    public List<Training> findAll() {
        if (trainingRepository.findAllByOrderByNameAsc().isEmpty()) {
            throw new ServiceException("No se encuentran Entrenamientos", HttpStatus.NOT_FOUND);
        }
        return trainingRepository.findAllByOrderByNameAsc();
    }

    /**
     * Actualiza el entrenamiento
     *
     * @param training
     * @return
     */
    public Training update(Training training) {
        findById(training.getIdTraining());
        return trainingRepository.save(training);
    }

    /**
     * Devuelve un entrenamiento con sus ejercicios
     *
     * @param id
     * @return
     */
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
            throw new ServiceException("El entrenamiento no tiene ejercicios", HttpStatus.NOT_FOUND);
        }

        return exercisesInTrainings;
    }
}
