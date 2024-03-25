package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.*;
import com.backend.DietAIbackend.mapper.AllergyMapper;
import com.backend.DietAIbackend.mapper.ClientMapper;
import com.backend.DietAIbackend.mapper.InjuryMapper;
import com.backend.DietAIbackend.model.Allergy;
import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.model.Injury;
import com.backend.DietAIbackend.model.User;
import com.backend.DietAIbackend.service.ClientService;
import com.backend.DietAIbackend.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${app.security.jwt.secret}")
    private String jwtSecret;

    @Autowired
    ClientService clientService;

    @Autowired
    UserService userService;

    @Autowired
    ClientMapper clientMapper;

    @Autowired
    AllergyMapper allergyMapper;

    @Autowired
    InjuryMapper injuryMapper;

    @GetMapping("/{idClient}")
    public ResponseEntity<ClientDto> findClientById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(clientMapper.modelToDto(clientService.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>>findAllClient(){
        List<Client> clientList = clientService.findAll();
        List<ClientDto> clientDtoList = clientMapper.listModelToDto(clientList);
        return ResponseEntity.ok().body(clientDtoList);
    }

    @PostMapping
    public ResponseEntity<ClientDto> registerClient(@RequestBody ClientDto clientDto){

        List<Allergy> allergyList = allergyMapper.listDtoToModel(clientDto.getAllergy());

        List<Injury> injuryList = injuryMapper.listDtoToModel(clientDto.getInjury());

        Client client = clientMapper.dtoToModel(clientDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientMapper.modelToDto(clientService.save(client, allergyList, injuryList)));
    }



    @PutMapping
    public ResponseEntity<ClientDto> updateClient(@RequestBody ClientDto clientDto){

        Client client = clientMapper.dtoToModel(clientDto);

        return ResponseEntity.ok().body(clientMapper.modelToDto(clientService.update(client)));

    }

    @DeleteMapping
    public void deleteClient(@RequestBody ClientDto clientDto){

        Client client = clientMapper.dtoToModel(clientDto);

        clientService.delete(client);
    }

    @DeleteMapping("{idClient}")
    public void deleteClient(@PathVariable Long idClient){

        clientService.deleteById(idClient);
    }

    @PostMapping("/diet/{idClient}")
    public ResponseEntity<ClientDto> asignarDieta(@PathVariable Long idClient){

        Client client = clientService.findById(idClient);

        return  ResponseEntity.ok().body(clientMapper.modelToDto(clientService.asignarDieta(client)));

    }

    @PostMapping("/training/{idClient}")
    public ResponseEntity<ClientDto> asignarEntrenamiento(@PathVariable Long idClient){

        Client client = clientService.findById(idClient);

        return  ResponseEntity.ok().body(clientMapper.modelToDto(clientService.asignarEntrenamiento(client)));

    }

    @GetMapping("/currentClient")
    public ResponseEntity<ClientDto> getCurrentClient(@RequestHeader("Authorization") String token){
        JwtParser validator = Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
                .build();
        Claims claims = validator.parseClaimsJws(token).getBody();
        claims.getId();
        return ResponseEntity.ok().body(clientMapper.modelToDto(clientService.findCurrentClient(Long.parseLong(claims.getId()))));
    }

}
