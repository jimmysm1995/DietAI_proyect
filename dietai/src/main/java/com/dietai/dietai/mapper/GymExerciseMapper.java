package com.dietai.dietai.mapper;


import com.dietai.dietai.dto.GymExerciseDto;
import com.dietai.dietai.model.GymExercise;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GymExerciseMapper {

    GymExerciseDto modelToDto(GymExercise gymExercise);

    GymExercise dtoToModel(GymExerciseDto gymExerciseDto);
}
