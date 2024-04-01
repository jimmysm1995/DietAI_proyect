package com.backend.DietAIbackend.mapper;

import com.backend.DietAIbackend.dto.TrainingExerciseDto;
import com.backend.DietAIbackend.model.TrainingExercise;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TrainingExerciseMapper {


    @Mapping(target = "training", ignore = true)
    @Mapping(target = "exercise", ignore = true)
    TrainingExerciseDto modelToDto(TrainingExercise trainingExercise);

    TrainingExercise dtoToModel(TrainingExerciseDto trainingExerciseDto);
}
