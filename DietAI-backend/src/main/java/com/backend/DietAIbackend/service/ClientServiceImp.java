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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    /**
     * Metodo para guardar al cliente junto a sus alergias y lesiones
     * @param client
     * @param allergyList
     * @param injuryList
     * @return Client
     */
    @Override
    public Client save(Client client, List<Allergy> allergyList, List<Injury> injuryList) {
        try {
            User user = userService.findById(client.getUser().getIdUser());

            client.setUser(user);
            client.setIdClient(user.getIdUser());

            user.setClient(client);

            userService.update(user);

            clientRepository.save(client);

            // Eliminar las relaciones existentes
            clientAllergyService.deleteAllByClient(client);
            clientInjuryService.deleteAllByClient(client);

            // Guarda las relaciones
            for (Allergy allergy : allergyList) {
                clientAllergyService.save(client, allergy);
            }

            for (Injury injury : injuryList) {
                clientInjuryService.save(client, injury);
            }

            return client;
        } catch (Exception e) {
            throw e;
        }
    }


    /**
     *
     * Encuentra el cliente por el id.
     *
     * @param id
     * @return Client
     */
    public Client findById(Long id){
        return clientRepository.findById(id).orElseThrow(
                () -> new ServiceException("No se ha encontrado el cliente", HttpStatus.NOT_FOUND)
        );
    }

    /**
     *
     * Devuelve una lista con todos los clientes
     *
     * @return List<Client>
     */
    @Override
    public List<Client> findAll() {
        try {
            List<Client> clientList = clientRepository.findAll();
            if (clientList.isEmpty()) {
                throw new ServiceException("No se encuentran clientes", HttpStatus.NOT_FOUND);
            }
            return clientList;
        } catch (Exception e) {
            throw e;
        }
    }


    /**
     *
     * Elimina al cliente por el id
     * @param id
     */
    @Override
    public void deleteById(Long id) {
        try {
            findById(id); // Este método lanza ServiceException si no se encuentra el cliente.
            clientRepository.deleteById(id);
        } catch (Exception e) {
            throw new ServiceException("Ocurrió un error inesperado al eliminar el cliente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Client update(Client client) {
        return null;
    }


    /**
     *
     * Modifica al cliente
     *
     * @param client
     * @return Client
     */
    @Override
    public Client update(Client client, List<Allergy> allergyList, List<Injury> injuryList) {
        try {
            findById(client.getIdClient());
            Client result =  clientRepository.save(client);


            // Eliminar las relaciones existentes
            clientAllergyService.deleteAllByClient(client);
            clientInjuryService.deleteAllByClient(client);

            // Guarda las relaciones
            for (Allergy allergy : allergyList) {
                clientAllergyService.save(client, allergy);
            }

            for (Injury injury : injuryList) {
                clientInjuryService.save(client, injury);
            }

            return result;
        } catch (Exception e) {
            throw new ServiceException("Ocurrió un error inesperado al actualizar el cliente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     *
     * Metodo para calcular el TMB, para saber las calorias recomendadas para el cliente
     *
     * @param client
     * @return
     */
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

    /**
     * Metodo para asignar la dieta al cliente
     *
     * @param client
     * @return
     */
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
                if (diferencia < menorDiferencia && hasMatchingAllergy(clientAllergyList, dieta.getDietAllergy())) {
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
        } catch (Exception e) {
            throw e;
        }
    }


    /**
     * Metodo para comprueba que dietas son compatibles para el cliente segun la alergia
     *
     * @param clientAllergies
     * @param dietAllergies
     * @return
     */
    private boolean hasMatchingAllergy(List<ClientAllergy> clientAllergies, List<DietAllergy> dietAllergies) {
        // Si no hay alergias del cliente, consideramos que la dieta es segura
        if (clientAllergies.isEmpty()) {
            return true;
        }

        // Crear un conjunto de ids de alergias de la dieta para una búsqueda más eficiente
        Set<Long> dietAllergyIds = dietAllergies.stream()
                .map(dietAllergy -> dietAllergy.getAllergy().getIdAllergy())
                .collect(Collectors.toSet());

        // Verificar si todas las alergias del cliente están en la lista de alergias de la dieta
        for (ClientAllergy clientAllergy : clientAllergies) {
            if (!dietAllergyIds.contains(clientAllergy.getAllergy().getIdAllergy())) {
                return false; // Si alguna alergia del cliente no está en la dieta, la dieta no es segura
            }
        }

        // Si todas las alergias del cliente están en la lista de alergias de la dieta, la dieta es segura
        return true;
    }


    /**
     * Metodo para asignar el entrenamiento al cliente
     *
     * @param client
     * @return
     */
    @Override
    public Client asignarEntrenamiento(Client client) {
        try {
            List<Training> trainingList = trainingRepository.findAll();
            Integer clientLevel = obtenerNivelCliente(client.getPreviousLevel());

            //Busca el entrenamiento perfecto segun los dias que puede entrenar, la dificultad
            for (Training training : trainingList) {
                if (training.getDays() == client.getTrainingTime() &&
                        (training.getTypeTraining() == client.getTypeTraining() || client.getTypeTraining().equals(TypeTraining.AMBOS)) &&
                        clientLevel <= training.getDifficulty()) {
                    client.setTraining(training);
                }
            }

            if (client.getTraining() == null) {
                log.error("No se ha encontrado un entrenamiento adecuado para el cliente");
                throw new ServiceException("No se ha encontrado un entrenamiento adecuado para el cliente", HttpStatus.NOT_FOUND);
            }

            return clientRepository.save(client);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Metodo para obtener el nivel de entrenamiento del cliente para asignar un entrenamiento acorde.
     *
     * @param previousLevel
     * @return
     */
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

    /**
     * Metodo que devuelve el client segun el usuario
     *
     * @param userId
     * @return
     */
    @Override
    public Client findCurrentClient(long userId) {
        try {
            return clientRepository.findClientByUserId(userId);
        } catch (Exception e) {
            throw new ServiceException("Ocurrió un error al buscar el cliente actual", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Metodo para devolver la dieta del usuario
     *
     * @param client
     * @return
     */
    @Override
    public Diet getDietByUser(Client client) {
        return client.getDiet();
    }

    /**
     * Metodo para devolver el entrenamiento del usuario
     *
     * @param client
     * @return
     */
    @Override
    public Training getTrainingByClient(Client client) {
        return client.getTraining();
    }

    /**
     * Metodo para devolver las alergias del usuario
     *
     * @param client
     * @return
     */
    @Override
    public List<Allergy> getAllergiesByClient(Client client) {

        List<Allergy> allergyList = new ArrayList<>();
        for (ClientAllergy clientAllergy: client.getClientAllergy()
        ) {
            allergyList.add(clientAllergy.getAllergy());
        }
        return allergyList;
    }

    /**
     * Metodo para devolver las lesiones del usuario
     *
     * @param client
     * @return
     */
    @Override
    public List<Injury> getInjuriesByClient(Client client) {
        List<Injury> injuryList = new ArrayList<>();
        for (ClientInjury clientInjury: client.getClientInjury()
        ) {
            injuryList.add(clientInjury.getInjury());
        }
        return injuryList;
    }

}
