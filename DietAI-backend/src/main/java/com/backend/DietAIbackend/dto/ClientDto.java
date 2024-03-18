package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.*;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class ClientDto {

    private Long id;

    private String name;

    private String lastName;

    private LocalDate birthDate;

    private Plan plan;

    private Gender gender;

    private Float weight;

    private Float height;

    private Goal goal;

    private List<InjuryDto> injury;

    private List<AllergyDto> allergy;

    private JobType jobType;

    private PreviusLevel previousLevel;

    private ConsumedSubstances consumedSubstances;

    private Integer trainingTime;

    private String dietAndExerciseFrequency;

    private UserDto user;

    private TrainingDto training;

    private DietDto diet;
}
