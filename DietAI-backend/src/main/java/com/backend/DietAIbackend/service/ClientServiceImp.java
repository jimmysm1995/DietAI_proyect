package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.*;
import com.backend.DietAIbackend.repository.ClientRepository;
import com.backend.DietAIbackend.repository.DietRepository;
import com.backend.DietAIbackend.repository.TrainingRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Client save(Client client, List<Allergy> allergyList, List<Injury> injuryList){

        User user = userService.findById(client.getUser().getIdUser());

        client.setUser(user);
        client.setIdClient(user.getIdUser());

        user.setClient(client);

        userService.update(user);

        clientRepository.save(client);


        for (Allergy allergy : allergyList) {
            clientAllergyService.save(client,allergy);
        }

        for (Injury injury : injuryList) {
            clientInjuryService.save(client,injury);
        }

        return client;
    }

    public Client findById(Long id){
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> findAll(){return clientRepository.findAll();}
    public void delete(Client client){ clientRepository.delete(client);}

    public void deleteById(Long id){ clientRepository.deleteById(id);}

    public Client update(Client client) {
        try {
            clientRepository.findById(client.getIdClient());
        } catch (EntityNotFoundException e){
            throw new ServiceException("No existe el cliente en cuestion");
        }

        return clientRepository.save(client);
    }

    public Client asignarDieta(Client client) {
        try {
            List<ClientAllergy> clientAllergyList = client.getClientAllergy();
            log.info("Empieza la funcion");

            // Calcular TMB
            Double tmb;
            Period periodo = Period.between(client.getBirthDate(), LocalDate.now());
            int edad = periodo.getYears();
            log.info(String.valueOf(edad));

            if (client.getGender() == (Gender.MASCULINO)) {
                tmb = 66.5 + (13.75 * client.getWeight()) + (5.003 * client.getHeight()) - (6.75 * edad);
            } else {
                tmb = 655.1 + (9.563 * client.getWeight()) + (1.850 * client.getHeight()) - (4.676 * edad);
            }

            // Obtener todas las dietas disponibles
            List<Diet> dietasDisponibles = dietRepository.findAll();

            // Inicializar variables para almacenar la mejor dieta y su diferencia de calorías
            Diet mejorDieta = null;
            Double menorDiferencia = Double.MAX_VALUE;

            // Calcular la diferencia de calorías para cada dieta
            for (Diet dieta : dietasDisponibles) {
                Double diferencia = Math.abs(dieta.getCalories() - tmb);
                if ((diferencia < menorDiferencia)) {
                    List<DietAllergy> dietAllergies = dieta.getDietAllergy();
                    if (hasMatchingAllergy(clientAllergyList, dietAllergies)) {
                        mejorDieta = dieta;
                        menorDiferencia = diferencia;
                    }
                }
            }

            // Asignar la mejor dieta al cliente
            if (mejorDieta != null) {
                client.setDiet(mejorDieta);
                return clientRepository.save(client);
            } else {
                log.error("No se pudo encontrar una dieta adecuada para el cliente.");
                return null;
            }
        } catch (Exception e) {
            log.error("Ocurrió un error al asignar la dieta al cliente: " + e.getMessage());
            return null;
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

    public Client asignarEntrenamiento(Client client){

        List<Training> trainingList = trainingRepository.findAll();

        for (Training training : trainingList) {
            if (training.getDays() == client.getTrainingTime() && training.getTypeTraining() == client.getTypeTraining()){
                client.setTraining(training);
            }
        }


        return clientRepository.save(client);
    }

    public Client findCurrentClient(long userId){
        return this.clientRepository.findClientByUserId(userId);
    }

    public Diet getDietByUser(Client client) {

        return client.getDiet();
    }

    @Override
    public Training getTrainingByClient(Client client) {
        return client.getTraining();
    }
}
