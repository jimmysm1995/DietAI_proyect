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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "ClientController", description = "Endpoint para los clientes")
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
    @Operation(summary = "Encuentra un cliente por el id")
    public ResponseEntity<ClientDto> findClientById(@PathVariable Long id){
        return ResponseEntity.ok().body(clientMapper.modelToDto(clientService.findById(id)));
    }

    @GetMapping
    @Operation(summary = "Devuelve toda la lista de los clientes")
    public ResponseEntity<List<ClientDto>>findAllClient(){

        return ResponseEntity.ok().body(clientMapper.listModelToDto(clientService.findAll()));
    }

    @PostMapping
    @Operation(summary = "Guarda al cliente")
    public ResponseEntity<ClientDto> registerClient(@RequestBody ClientDto clientDto){

        List<Allergy> allergyList = allergyMapper.listDtoToModel(clientDto.getAllergy());

        List<Injury> injuryList = injuryMapper.listDtoToModel(clientDto.getInjury());

        Client client = clientMapper.dtoToModel(clientDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientMapper.modelToDto(clientService.save(client, allergyList, injuryList)));
    }

    @PutMapping
    @Operation(summary = "Modifica al cliente")
    public ResponseEntity<ClientDto> updateClient(@RequestBody ClientDto clientDto){

        List<Allergy> allergyList = allergyMapper.listDtoToModel(clientDto.getAllergy());

        List<Injury> injuryList = injuryMapper.listDtoToModel(clientDto.getInjury());

        Client client = clientMapper.dtoToModel(clientDto);

        return ResponseEntity.ok().body(clientMapper.modelToDto(clientService.update(client, allergyList, injuryList)));

    }

    @DeleteMapping("/{idClient}")
    @Operation(summary = "Elimina un cliente por el id")
    public ResponseEntity<Void> deleteClient(@PathVariable Long idClient){

        clientService.deleteById(idClient);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/diet/{idClient}")
    @Operation(summary = "Asigna una dieta al cliente")
    public ResponseEntity<ClientDto> asignarDieta(@PathVariable Long idClient){

        Client client = clientService.findById(idClient);

        return  ResponseEntity.ok().body(clientMapper.modelToDto(clientService.asignarDieta(client)));

    }

    @PostMapping("/training/{idClient}")
    @Operation(summary = "Asigna un entrenamiento al cliente")
    public ResponseEntity<ClientDto> asignarEntrenamiento(@PathVariable Long idClient){

        Client client = clientService.findById(idClient);

        return  ResponseEntity.ok().body(clientMapper.modelToDto(clientService.asignarEntrenamiento(client)));

    }

    @GetMapping("/getDiet/{idClient}")
    @Operation(summary = "Devuelve la dieta del cliente")
    public ResponseEntity<DietDto> getDietByClient(@PathVariable Long idClient){

        Client client = clientService.findById(idClient);

        return ResponseEntity.ok().body(dietMapper.modelToDto(clientService.getDietByUser(client)));
    }

    @GetMapping("/getTraining/{idClient}")
    @Operation(summary = "Devuelve el entrenamiento del cliente")
    public ResponseEntity<TrainingDto> getTrainingByClient(@PathVariable Long idClient){

        Client client = clientService.findById(idClient);

        return ResponseEntity.ok().body(trainingMapper.modelToDto(clientService.getTrainingByClient(client)));
    }

    @GetMapping("/getAllergies/{id}")
    @Operation(summary = "Obtiene las alergias del cliente")
    public ResponseEntity<List<AllergyDto>> getAllergiesByClient(@PathVariable Long id){
        Client client = clientService.findById(id);

        return ResponseEntity.ok().body(allergyMapper.listModelToDto(clientService.getAllergiesByClient(client)));
    }

    @GetMapping("/getInjuries/{id}")
    @Operation(summary = "Obtiene las lesiones del cliente")
    public ResponseEntity<List<InjuryDto>> getInjuriesByClient(@PathVariable Long id){
        Client client = clientService.findById(id);
        return ResponseEntity.ok().body(injuryMapper.listModelToDto(clientService.getInjuriesByClient(client)));
    }

}
