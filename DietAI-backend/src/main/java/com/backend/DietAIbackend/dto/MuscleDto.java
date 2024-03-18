package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.GymExerciseMuscle;
import com.backend.DietAIbackend.model.HomeExerciseMuscle;
import lombok.Data;

import java.util.List;

@Data
public class MuscleDto {

    private Long id;

    private String name;

    private List<HomeExerciseMuscleDto> homeExerciseMuscles;

    private List<GymExerciseMuscleDto> gymExerciseMuscles;


}
