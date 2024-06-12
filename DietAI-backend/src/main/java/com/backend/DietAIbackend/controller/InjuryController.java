package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.InjuryDto;
import com.backend.DietAIbackend.mapper.InjuryMapper;
import com.backend.DietAIbackend.model.Injury;
import com.backend.DietAIbackend.service.InjuryService;
import com.backend.DietAIbackend.service.InjuryServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/injury")
@CrossOrigin(origins = "${cors.allowed.origin}")
@Slf4j
@Tag(name = "InjuryController", description = "Endpoint para las lesiones de los clientes")
public class InjuryController {

    @Autowired
    InjuryService injuryService;

    @Autowired
    InjuryMapper injuryMapper;


    @GetMapping
    @Operation(summary = "Devuelve una lista con las lesiones")
    public ResponseEntity<List<InjuryDto>>findAll(){

        return ResponseEntity.ok().body(injuryMapper.listModelToDto(injuryService.findAll()));
    }
}
