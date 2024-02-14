package com.dietai.dietai.mapper;


import com.dietai.dietai.dto.TrainingDto;
import com.dietai.dietai.model.Training;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainingMapper {

    TrainingDto modelToDto(Training training);

    Training dtoToModel(TrainingDto trainingDto);
}
