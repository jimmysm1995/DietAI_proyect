package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.InjuryDto;
import com.backend.DietAIbackend.mapper.InjuryMapper;
import com.backend.DietAIbackend.model.Injury;
import com.backend.DietAIbackend.service.InjuryService;
import com.backend.DietAIbackend.service.InjuryServiceImp;
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


    @GetMapping
    public ResponseEntity<List<InjuryDto>>findAll(){

        return ResponseEntity.ok().body(injuryMapper.listModelToDto(injuryService.findAll()));
    }
}
