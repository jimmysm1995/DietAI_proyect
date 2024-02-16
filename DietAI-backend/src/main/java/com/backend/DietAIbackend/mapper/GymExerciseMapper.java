package com.backend.DietAIbackend.mapper;

import com.backend.DietAIbackend.dto.GymExerciseDto;
import com.backend.DietAIbackend.model.GymExercise;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GymExerciseMapper {

    GymExerciseDto modelToDto(GymExercise gymExercise);

    GymExercise dtoToModel(GymExerciseDto gymExerciseDto);
}
