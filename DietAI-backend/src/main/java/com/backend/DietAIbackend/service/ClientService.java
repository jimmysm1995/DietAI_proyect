package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.*;

import java.util.List;

public interface ClientService extends ICrudService <Client, Long>{
    Client save(Client client, List<Allergy> allergyList, List<Injury> injuryList);

    Client update(Client client, List<Allergy> allergyList, List<Injury> injuryList);
    Client asignarDieta(Client client);
    Client asignarEntrenamiento(Client client);
    Client findCurrentClient(long userId);
    Diet getDietByUser(Client client);
    Training getTrainingByClient(Client client);
    List<Allergy> getAllergiesByClient(Client client);

    List<Injury> getInjuriesByClient(Client client);
}
