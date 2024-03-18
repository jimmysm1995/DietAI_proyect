package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.*;
import com.backend.DietAIbackend.repository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientAllergyRepository clientAllergyRepository;

    @Autowired
    ClientInjuryRepository clientInjuryRepository;

    @Autowired
    DietRepository dietRepository;

    @Autowired
    TrainingRepository trainingRepository;

    @Autowired
    UserService userService;

    @Transactional
    public Client save(Client client, List<Injury>injuryList, List<Allergy>allergyList){

        User user = userService.findById(client.getUser().getId());

        log.info(user.getUsername());

        client.setUser(user);

        log.info(client.getName());

        clientRepository.save(client);

        if (!allergyList.isEmpty()){
            log.info("Recorre lista");
            for (Allergy allergy : allergyList) {
                ClientAllergy clientAllergy = new ClientAllergy();
                clientAllergy.setClient(client);
                clientAllergy.setAllergy(allergy);
                clientAllergyRepository.save(clientAllergy);
            }
        } else {
            log.info("La lista de alergias esta vacia");
        }

        if (!injuryList.isEmpty()){
            log.info("Recorre lista");
            for (Injury injury : injuryList) {
                ClientInjury clientInjury = new ClientInjury();
                log.info(injury.getId().toString());
                clientInjury.setClient(client);
                clientInjury.setInjury(injury);
                clientInjuryRepository.save(clientInjury);
            }
        } else {
            log.info("La lista de lesiones esta vacia");
        }

        return client;
    }

    public Client findById(Long id){
        return clientRepository.findById(id).orElse(null);
    }

    public List<Client> findAll(){return clientRepository.findAll();}
    public void delete(Client client){ clientRepository.delete(client);}

    public void deleteById(Long id){ clientRepository.deleteById(id);}

    public Client update(Client client) {
        try {
            User user = userService.findById(client.getUser().getIdUser());
            client.setUser(user);
            log.info("Pasa por aqui");
            clientRepository.findById(client.getUser().getIdUser());
        } catch (EntityNotFoundException e){
            throw new ServiceException("No existe el cliente en cuestion");
        }
        log.info("Pasa por aqui");
        return clientRepository.save(client);
    }

    public Client asignarDieta(Client client) {

        log.info("Empieza la funcion");

        Double tmb;

        // Calcular la diferencia entre las fechas
        Period periodo = Period.between(client.getBirthDate(), LocalDate.now());

        // Obtener la edad en años
        int edad = periodo.getYears();

        log.info(String.valueOf(edad));

        if (client.getGender() == (Gender.MALE)) {
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
            if (diferencia < menorDiferencia) {
                mejorDieta = dieta;
                menorDiferencia = diferencia;
            }
        }

        // Asignar la mejor dieta al cliente
        client.setDiet(mejorDieta);

        return clientRepository.save(client);
    }

    public Client asignarEntrenamiento(Client client){

        List<Training> trainingList = trainingRepository.findAll();

        for (Training training : trainingList) {
            if (training.getDays() == client.getTrainingTime()){
                client.setTraining(training);
            }
        }


        return clientRepository.save(client);
    }

    public Client findCurrentClient(long userId){
        return this.clientRepository.findClientByUserId(userId);
    }
}
