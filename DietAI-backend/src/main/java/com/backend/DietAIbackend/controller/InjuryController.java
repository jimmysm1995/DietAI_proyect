package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.AllergyDto;
import com.backend.DietAIbackend.dto.InjuryDto;
import com.backend.DietAIbackend.mapper.AllergyMapper;
import com.backend.DietAIbackend.mapper.InjuryMapper;
import com.backend.DietAIbackend.model.Allergy;
import com.backend.DietAIbackend.model.Injury;
import com.backend.DietAIbackend.service.AllergyService;
import com.backend.DietAIbackend.service.InjuryService;
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
public class InjuryController {

    @Autowired
    InjuryService injuryService;

    @Autowired
    InjuryMapper injuryMapper;

    @PostMapping
    public ResponseEntity<InjuryDto> save(@RequestBody InjuryDto injuryDto){
        Injury injury = injuryMapper.dtoToModel(injuryDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(injuryMapper.modelToDto(injuryService.save(injury)));
    }

    @GetMapping
    public ResponseEntity<List<InjuryDto>>findAll(){

        return ResponseEntity.ok().body(injuryMapper.listModelToDto(injuryService.findAll()));
    }

    @GetMapping("/{idInjury}")
    public ResponseEntity<InjuryDto>findById(@PathVariable Long idInjury){

        log.info(injuryService.findById(idInjury).getName());

        return ResponseEntity.ok().body(injuryMapper.modelToDto(injuryService.findById(idInjury)));
    }
}
