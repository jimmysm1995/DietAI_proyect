package com.dietai.dietai.dto;


import com.dietai.dietai.model.Gender;
import com.dietai.dietai.model.Plan;
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
