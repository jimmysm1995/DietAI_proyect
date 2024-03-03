package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.ClientDto;
import com.backend.DietAIbackend.dto.UserDto;
import com.backend.DietAIbackend.mapper.ClientMapper;
import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.model.User;
import com.backend.DietAIbackend.repository.ClientRepository;
import com.backend.DietAIbackend.service.ClientService;
import com.backend.DietAIbackend.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    UserService userService;

    @Autowired
    ClientMapper clientMapper;

    @PostMapping("/register")
    public void registerClient(@RequestBody ClientDto clientDto){

        Client client = clientMapper.dtoToModel(clientDto);

        User user = userService.findByUsername(clientDto.getUser().getUsername()).orElse(null);

        client.setUser(user);

        clientRepository.save(client);

    }
}
