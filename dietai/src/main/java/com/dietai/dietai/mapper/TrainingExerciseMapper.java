package com.dietai.dietai.mapper;


import com.dietai.dietai.dto.TrainingExerciseDto;
import com.dietai.dietai.model.TrainingExercise;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainingExerciseMapper {

    TrainingExerciseDto modelToDto(TrainingExercise trainingExercise);

    TrainingExercise dtoToModel(TrainingExerciseDto trainingExerciseDto);
}
