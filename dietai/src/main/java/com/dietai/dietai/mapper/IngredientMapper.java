package com.dietai.dietai.mapper;

import com.dietai.dietai.dto.IngredientDto;
import com.dietai.dietai.model.Ingredient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IngredientMapper {

    IngredientDto modelToDto(Ingredient ingredient);

    Ingredient dtoToModel(IngredientDto ingredientDto);
}
