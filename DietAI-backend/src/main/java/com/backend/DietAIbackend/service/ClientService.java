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

    public Client save(Client client){

        User user = userService.findById(client.getUser().getIdUser());

        client.setUser(user);
        client.setIdClient(user.getIdUser());

        user.setClient(client);

        userService.update(user);

        return clientRepository.save(client);
    }

    public Client findById(Long id){
        return clientRepository.findById(id).orElse(null);
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
}
