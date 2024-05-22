package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.*;
import com.backend.DietAIbackend.mapper.*;
import com.backend.DietAIbackend.model.Allergy;
import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.model.Injury;
import com.backend.DietAIbackend.service.ClientService;
import com.backend.DietAIbackend.service.ClientServiceImp;
import com.backend.DietAIbackend.service.UserService;
import com.backend.DietAIbackend.service.UserServiceImp;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "${cors.allowed.origin}")
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

    @Autowired
    private DietMapper dietMapper;

    @Autowired
    private TrainingMapper trainingMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> findClientById(@PathVariable Long id){
        return ResponseEntity.ok().body(clientMapper.modelToDto(clientService.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>>findAllClient(){

        return ResponseEntity.ok().body(clientMapper.listModelToDto(clientService.findAll()));
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

    @DeleteMapping("/{idClient}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long idClient){

        clientService.deleteById(idClient);
        return ResponseEntity.noContent().build();
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

        if (StringUtils.hasLength(token) && token.startsWith("Bearer")){
            token = token.substring("Bearer ".length());
        }

        JwtParser validator = Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
                .build();

        Claims claims = validator.parseClaimsJws(token).getBody();
        claims.getId();
        return ResponseEntity.ok().body(clientMapper.modelToDto(clientService.findCurrentClient(Long.parseLong(claims.getSubject()))));
    }

    @GetMapping("/getDiet/{idClient}")
    public ResponseEntity<DietDto> getDietByClient(@PathVariable Long idClient){

        Client client = clientService.findById(idClient);

        return ResponseEntity.ok().body(dietMapper.modelToDto(clientService.getDietByUser(client)));
    }

    @GetMapping("/getTraining/{idClient}")
    public ResponseEntity<TrainingDto> getTrainingByClient(@PathVariable Long idClient){

        Client client = clientService.findById(idClient);

        return ResponseEntity.ok().body(trainingMapper.modelToDto(clientService.getTrainingByClient(client)));
    }

}
