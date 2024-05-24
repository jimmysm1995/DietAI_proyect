package com.backend.DietAIbackend.service.sheduled;

import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ScheduledService {

    @Autowired
    ClientService clientService;

    @Scheduled(cron = "${cron.everyMonth}")
    public void renoveDietAndTraining(){
        log.info("Se van a actualizar las dietas y entrenamientos de los clientes");
        List<Client> clientList = clientService.findAll();
        for (Client client: clientList
             ) {
            clientService.asignarDieta(client);
            clientService.asignarEntrenamiento(client);
        }
        log.info("Se han actualizado las dietas y entrenamientos de los clientes");
    }
}
