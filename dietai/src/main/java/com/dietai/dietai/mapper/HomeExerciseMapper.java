package com.dietai.dietai.mapper;

import com.dietai.dietai.dto.HomeExerciseDto;
import com.dietai.dietai.model.HomeExercise;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HomeExerciseMapper {

    HomeExerciseDto modelToDto(HomeExercise homeExercise);

    HomeExercise dtoToModel(HomeExerciseDto homeExerciseDto);
}
