package com.backend.DietAIbackend.mapper;


import com.backend.DietAIbackend.dto.ClientDto;
import com.backend.DietAIbackend.dto.TrainingDto;
import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.model.Training;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TrainingMapper {

    @Mapping(target = "trainingExercises", ignore = true)
    @Mapping(target = "clients", ignore = true)
    TrainingDto modelToDto(Training training);

    Training dtoToModel(TrainingDto trainingDto);

    List<Training> listDtoToModel(List<TrainingDto> trainingDtoList);

    List<TrainingDto> listModelToDto(List<Training> trainingList);
}
