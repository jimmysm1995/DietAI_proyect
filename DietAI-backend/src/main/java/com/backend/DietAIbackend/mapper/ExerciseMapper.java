package com.backend.DietAIbackend.mapper;

import com.backend.DietAIbackend.dto.ExerciseDto;
import com.backend.DietAIbackend.model.Exercise;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {

    @Mapping(target = "exerciseMuscles", ignore = true)
    ExerciseDto modelToDto(Exercise exercise);

    Exercise dtoToModel(ExerciseDto exerciseDto);

    List<Exercise> listDtoToModel(List<ExerciseDto> exerciseDtoList);

    List<ExerciseDto> listModelToDto(List<Exercise> exerciseList);
}
