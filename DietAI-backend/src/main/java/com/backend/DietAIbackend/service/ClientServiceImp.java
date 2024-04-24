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

        log.info("Empieza la funcion");

        Double tmb;

        // Calcular la diferencia entre las fechas
        Period periodo = Period.between(client.getBirthDate(), LocalDate.now());

        // Obtener la edad en años
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
}
