package com.dietai.dietai.mapper;


import com.dietai.dietai.dto.IngredientRecipeDto;
import com.dietai.dietai.model.IngredientRecipe;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IngredientRecipeMapper {

    IngredientRecipeDto modelToDto(IngredientRecipe ingredientRecipe);

    IngredientRecipe dtoToModel(IngredientRecipeDto ingredientRecipeDto);

}
