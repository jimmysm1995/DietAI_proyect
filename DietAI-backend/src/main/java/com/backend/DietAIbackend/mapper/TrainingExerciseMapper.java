package com.backend.DietAIbackend.mapper;

import com.backend.DietAIbackend.dto.TrainingExerciseDto;
import com.backend.DietAIbackend.model.TrainingExercise;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainingExerciseMapper {

    TrainingExerciseDto modelToDto(TrainingExercise trainingExercise);

    TrainingExercise dtoToModel(TrainingExerciseDto trainingExerciseDto);
}
