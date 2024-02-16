package com.backend.DietAIbackend.mapper;


import com.backend.DietAIbackend.dto.TrainingDto;
import com.backend.DietAIbackend.model.Training;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainingMapper {

    TrainingDto modelToDto(Training training);

    Training dtoToModel(TrainingDto trainingDto);
}
