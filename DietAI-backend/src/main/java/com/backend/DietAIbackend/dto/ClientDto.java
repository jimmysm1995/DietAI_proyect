package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.*;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
public class ClientDto {

    private String name;

    private String lastName;

    private LocalDate fechaNacimiento;

    private Plan plan;

    private Gender gender;

    private Float weight;

    private Float height;

    private Goal goal;

    private String injuries;

    private ArrayList<AllergyDto> allergies;

    private String jobType;

    private String previousLevel;

    private String consumedSubstances;

    private Integer trainingTime;

    private String dietAndExerciseFrequency;

    private UserDto user;

    private TrainingDto training;

    private DietDto diet;
}
