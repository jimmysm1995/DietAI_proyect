package com.backend.DietAIbackend.mapper;

import com.backend.DietAIbackend.dto.IngredientRecipeDto;
import com.backend.DietAIbackend.model.IngredientRecipe;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IngredientRecipeMapper {

    IngredientRecipeDto modelToDto(IngredientRecipe ingredientRecipe);

    IngredientRecipe dtoToModel(IngredientRecipeDto ingredientRecipeDto);

}
