package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.exception.ServiceException;
import com.backend.DietAIbackend.model.*;
import com.backend.DietAIbackend.repository.ClientRepository;
import com.backend.DietAIbackend.repository.DietRepository;
import com.backend.DietAIbackend.repository.TrainingRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
@Slf4j
public class ClientServiceImp implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    DietRepository dietRepository;

    @Autowired
    TrainingRepository trainingRepository;

    @Autowired
    ClientAllergyService clientAllergyService;

    @Autowired
    ClientInjuryService clientInjuryService;

    @Autowired
    UserService userService;

    @Override
    public Client save(Client client, List<Allergy> allergyList, List<Injury> injuryList) {
        try {
            User user = userService.findById(client.getUser().getIdUser());

            client.setUser(user);
            client.setIdClient(user.getIdUser());

            user.setClient(client);

            userService.update(user);

            clientRepository.save(client);

            for (Allergy allergy : allergyList) {
                clientAllergyService.save(client, allergy);
            }

            for (Injury injury : injuryList) {
                clientInjuryService.save(client, injury);
            }

            return client;
        } catch (DataIntegrityViolationException e) {
            throw new ServiceException("Ha habido un problema al guardar al cliente en la base de datos", HttpStatus.CONFLICT);
        } catch (Exception e) {
            throw new ServiceException("Ocurrió un error inesperado al guardar el cliente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public Client findById(Long id){
        return clientRepository.findById(id).orElseThrow(
                () -> new ServiceException("No se ha encontrado el cliente", HttpStatus.NOT_FOUND)
        );
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> findAll() {
        try {
            List<Client> clientList = clientRepository.findAll();
            if (clientList.isEmpty()) {
                throw new ServiceException("No se encuentran clientes", HttpStatus.NOT_FOUND);
            }
            return clientList;
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException("Ocurrió un error inesperado al obtener los clientes: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @Override
    public void deleteById(Long id) {
        try {
            findById(id); // Este método lanza ServiceException si no se encuentra el cliente.
            clientRepository.deleteById(id);
        } catch (ServiceException e) {
            throw e;
        } catch (DataIntegrityViolationException e) {
            throw new ServiceException("Ha habido un problema al eliminar al cliente de la base de datos", HttpStatus.CONFLICT);
        } catch (Exception e) {
            throw new ServiceException("Ocurrió un error inesperado al eliminar el cliente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public Client update(Client client) {
        try {
            findById(client.getIdClient());
            return clientRepository.save(client);
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException("Ocurrió un error inesperado al actualizar el cliente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    private Integer calcularTMB(Client client){

        Double tmb;

        //Se calcula la edad del cliente
        Period periodo = Period.between(client.getBirthDate(), LocalDate.now());
        int edad = periodo.getYears();

        //Dependiendo del genero, se calcula cual es el TMB del cliente
        if (client.getGender() == Gender.MASCULINO) {
            tmb = 66.5 + (13.75 * client.getWeight()) + (5.003 * client.getHeight()) - (6.75 * edad);
        } else if (client.getGender() == Gender.FEMENINO) {
            tmb = 655.1 + (9.563 * client.getWeight()) + (1.850 * client.getHeight()) - (4.676 * edad);
        } else {
            // Para género "OTRO", calculamos la media entre la fórmula masculina y la femenina
            Double tmbMasculino = 66.5 + (13.75 * client.getWeight()) + (5.003 * client.getHeight()) - (6.75 * edad);
            Double tmbFemenino = 655.1 + (9.563 * client.getWeight()) + (1.850 * client.getHeight()) - (4.676 * edad);
            tmb = (tmbMasculino + tmbFemenino) / 2;
        }

        //Dependiendo del tipo de trabajo, se modificará la cantidad de calorias recomendadas
        switch (client.getJobType()){
            case SEDENTARIO -> tmb += 100;
            case MEDIO_ACTIVO -> tmb += 200;
            case ACTIVO -> tmb += 300;
            case MUY_ACTIVO -> tmb += 400;
        }

        //Dependiendo del objetivo, se modificará las cantidades de calorias recomendadas
        if (client.getGoal() == Goal.PERDER_PESO) {
            tmb -= 500;
        }
        if (client.getGoal() == Goal.GANAR_PESO) {
            tmb += 500;
        }

        //Se devuelve el resultado sin decimales
        return (int) Math.round(tmb);
    }

    @Override
    public Client asignarDieta(Client client) {
        try {
            List<ClientAllergy> clientAllergyList = client.getClientAllergy();
            log.info("Empieza la función");

            Integer caloriasRecomendadas = calcularTMB(client);
            client.setRecommendedDailyCalories(caloriasRecomendadas);

            List<Diet> dietasDisponibles = dietRepository.findAll();

            Diet mejorDieta = null;
            Integer menorDiferencia = Integer.MAX_VALUE;

            for (Diet dieta : dietasDisponibles) {
                Integer diferencia = Math.abs(dieta.getCalories() - caloriasRecomendadas);
                if (diferencia < menorDiferencia && !hasMatchingAllergy(clientAllergyList, dieta.getDietAllergy())) {
                    mejorDieta = dieta;
                    menorDiferencia = diferencia;
                }
            }

            if (mejorDieta != null) {
                client.setDiet(mejorDieta);
            } else {
                log.error("No se pudo encontrar una dieta adecuada para el cliente.");
                throw new ServiceException("No se ha encontrado una dieta adecuada para el cliente", HttpStatus.NOT_FOUND);
            }

            return clientRepository.save(client);
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            log.error("Ocurrió un error al asignar la dieta al cliente: " + e.getMessage());
            throw new ServiceException("Ocurrió un error al asignar la dieta al cliente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    private boolean hasMatchingAllergy(List<ClientAllergy> clientAllergies, List<DietAllergy> dietAllergies) {
        for (ClientAllergy clientAllergy : clientAllergies) {
            for (DietAllergy dietAllergy : dietAllergies) {
                if (clientAllergy.getAllergy().getIdAllergy().equals(dietAllergy.getAllergy().getIdAllergy())) {
                    return true; // Si hay una coincidencia de alergia, devolver true
                }
            }
        }
        return false; // Si no se encuentra ninguna coincidencia, devolver false
    }

    @Override
    public Client asignarEntrenamiento(Client client) {
        try {
            List<Training> trainingList = trainingRepository.findAll();
            Integer clientLevel = obtenerNivelCliente(client.getPreviousLevel());

            for (Training training : trainingList) {
                if (training.getDays() == client.getTrainingTime() &&
                        training.getTypeTraining() == client.getTypeTraining() &&
                        clientLevel.equals(training.getDifficulty())) {
                    client.setTraining(training);
                }
            }

            if (client.getTraining() == null) {
                log.error("No se ha encontrado un entrenamiento adecuado para el cliente");
                throw new ServiceException("No se ha encontrado un entrenamiento adecuado para el cliente", HttpStatus.NOT_FOUND);
            }

            return clientRepository.save(client);
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            log.error("Error al asignar entrenamiento: " + e.getMessage());
            throw new ServiceException("Error al asignar entrenamiento", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private Integer obtenerNivelCliente(PreviusLevel previousLevel) {
        switch (previousLevel) {
            case NUNCA_HE_ENTRENADO:
                return 1;
            case ENTRENO_POCO:
                return 2;
            case ENTRENO_BASTANTE:
                return 3;
            case ENTRENO_MUCHO:
                return 4;
            case ENTRENO_A_DIARIO:
                return 5;
            default:
                log.info("No se ha especificado el nivel, por lo que se deja el más bajo posible");
                return 0;
        }
    }
    @Override
    public Client findCurrentClient(long userId) {
        try {
            return clientRepository.findClientByUserId(userId);
        } catch (Exception e) {
            throw new ServiceException("Ocurrió un error al buscar el cliente actual", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Diet getDietByUser(Client client) {
        return client.getDiet();
    }

    @Override
    public Training getTrainingByClient(Client client) {
        return client.getTraining();
    }

}
