package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.ClientDto;
import com.backend.DietAIbackend.mapper.ClientMapper;
import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.model.User;
import com.backend.DietAIbackend.service.ClientService;
import com.backend.DietAIbackend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    UserService userService;

    @Autowired
    ClientMapper clientMapper;

    @PostMapping
    public ResponseEntity<ClientDto> registerClient(@RequestBody ClientDto clientDto){

        Client client = clientMapper.dtoToModel(clientDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(clientMapper.modelToDto(clientService.registerClient(client)));
    }

    @GetMapping
    public List<Client>findAllClient(){
        return clientService.findAllClient();
    }

    @GetMapping("/{idClient}")
    public ResponseEntity<ClientDto> findClientById(Long id){

        return ResponseEntity.status(HttpStatus.CREATED).body(clientMapper.modelToDto(clientService.findClientById(id)));

    }

    @PutMapping
    public ResponseEntity<ClientDto> updateClient(@RequestBody ClientDto clientDto){

        Client client = clientMapper.dtoToModel(clientDto);

        return ResponseEntity.ok().body(clientMapper.modelToDto(clientService.updateClient(client)));

    }

    @DeleteMapping
    public void deleteClient(@RequestBody ClientDto clientDto){

        Client client = clientMapper.dtoToModel(clientDto);

        clientService.deleteClient(client);
    }

    @DeleteMapping("{idClient}")
    public void deleteClient(@PathVariable Long idClient){

        clientService.deleteClient(idClient);
    }

}
