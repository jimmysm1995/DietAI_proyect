package com.backend.DietAIbackend.mapper;

import com.backend.DietAIbackend.dto.ClientDto;
import com.backend.DietAIbackend.dto.HomeExerciseDto;
import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.model.HomeExercise;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HomeExerciseMapper {

    @Mapping(target = "homeExerciseMuscles", ignore = true)
    HomeExerciseDto modelToDto(HomeExercise homeExercise);

    HomeExercise dtoToModel(HomeExerciseDto homeExerciseDto);

    List<HomeExercise> listDtoToModel(List<HomeExerciseDto> homeExerciseDtoList);

    List<HomeExerciseDto> listModelToDto(List<HomeExercise> homeExerciseList);
}
