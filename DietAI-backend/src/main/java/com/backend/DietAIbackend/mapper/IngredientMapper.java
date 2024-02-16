package com.backend.DietAIbackend.mapper;

import com.backend.DietAIbackend.dto.IngredientDto;
import com.backend.DietAIbackend.model.Ingredient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IngredientMapper {

    IngredientDto modelToDto(Ingredient ingredient);

    Ingredient dtoToModel(IngredientDto ingredientDto);
}
