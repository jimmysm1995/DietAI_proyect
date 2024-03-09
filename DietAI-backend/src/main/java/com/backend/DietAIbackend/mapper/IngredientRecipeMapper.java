package com.backend.DietAIbackend.mapper;

import com.backend.DietAIbackend.dto.IngredientDto;
import com.backend.DietAIbackend.dto.IngredientRecipeDto;
import com.backend.DietAIbackend.model.Ingredient;
import com.backend.DietAIbackend.model.IngredientRecipe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IngredientRecipeMapper {

    @Mapping(target = "ingredient", ignore = true)
    @Mapping(target = "recipe", ignore = true)
    IngredientRecipeDto modelToDto(IngredientRecipe ingredientRecipe);

    IngredientRecipe dtoToModel(IngredientRecipeDto ingredientRecipeDto);
    List<IngredientRecipeDto> listModelToDto(List<IngredientRecipe> ingredientRecipeList);

}
