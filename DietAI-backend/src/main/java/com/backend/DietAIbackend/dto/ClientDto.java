package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientDto {

    private String name;

    private String lastName;

    private LocalDate fechaNacimiento;

    private Plan plan;

    private Gender gender;

    private UserDto user;

    private InfoClientDto infoClient;

    private TrainingDto training;

    private DietDto diet;
}
