package com.backend.DietAIbackend.mapper;

import com.backend.DietAIbackend.dto.HomeExerciseDto;
import com.backend.DietAIbackend.model.HomeExercise;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HomeExerciseMapper {

    HomeExerciseDto modelToDto(HomeExercise homeExercise);

    HomeExercise dtoToModel(HomeExerciseDto homeExerciseDto);
}
