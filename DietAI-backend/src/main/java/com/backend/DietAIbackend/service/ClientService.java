package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.model.User;
import com.backend.DietAIbackend.repository.ClientRepository;
import com.backend.DietAIbackend.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    UserService userService;

    public Client registerClient(Client client){

        log.info(client.getUser().getIdUser().toString());

        User user = userService.findById(client.getUser().getIdUser());

        client.setUser(user);

        user.setClient(client);

        return clientRepository.save(client);
    }

    public Client findClientById(Long id){
        return clientRepository.findById(id).orElse(null);
    }

    public List<Client> findAllClient(){return clientRepository.findAll();}
    public void deleteClient(Client client){ clientRepository.delete(client);}

    public void deleteClient(Long id){ clientRepository.deleteById(id);}

    public Client updateClient(Client client) {
        try {
            clientRepository.findById(client.getIdClient());
        } catch (EntityNotFoundException e){
            throw new ServiceException("No existe el cliente en cuestion");
        }

        return clientRepository.save(client);
    }
}
