package com.backend.DietAIbackend.mapper;

import com.backend.DietAIbackend.dto.GymExerciseDto;
import com.backend.DietAIbackend.dto.HomeExerciseDto;
import com.backend.DietAIbackend.model.GymExercise;
import com.backend.DietAIbackend.model.HomeExercise;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GymExerciseMapper {

    @Mapping(target = "gymExerciseMuscles", ignore = true)
    @Mapping(target = "trainingExercises", ignore = true)
    GymExerciseDto modelToDto(GymExercise gymExercise);

    GymExercise dtoToModel(GymExerciseDto gymExerciseDto);

    List<GymExercise> listDtoToModel(List<GymExerciseDto> gymExerciseDtoList);

    List<GymExerciseDto> listModelToDto(List<GymExercise> gymExerciseList);
}
