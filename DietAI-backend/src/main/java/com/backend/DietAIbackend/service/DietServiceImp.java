package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.dto.IngredientSummary;
import com.backend.DietAIbackend.dto.RecipeInDiet;
import com.backend.DietAIbackend.model.*;
import com.backend.DietAIbackend.repository.DietRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DietServiceImp implements DietService {

    @Autowired
    DietRepository dietRepository;

    @Autowired
    RecipeDietService recipeDietService;

    @Autowired
    RecipeService recipeService;

    @Autowired
    DietAllergyService dietAllergyService;

    @Transactional
    @Override
    public Diet save(Diet diet, List<RecipeInDiet> recipeInDietList, List<Allergy> allergyList) {

        Diet dieta = dietRepository.save(diet);

        for (RecipeInDiet recipeInDiet : recipeInDietList
        ) {
            if (recipeInDiet.recipe() != null){
                RecipeDiet recipeDiet = new RecipeDiet();
                recipeDiet.setDiet(diet);
                recipeDiet.setRecipe(recipeInDiet.recipe());
                recipeDiet.setDayWeek(recipeInDiet.dayWeek());
                recipeDiet.setMealTime(recipeInDiet.mealTime());
                recipeDietService.save(recipeDiet);
            }
        }

        for (Allergy allergy : allergyList) {
            dietAllergyService.save(diet,allergy);
        }
        
        actualizarCalorias();

        return dieta;
    }

    @Override
    public List<IngredientSummary> getListaCompra(Long id){

        return dietRepository.getIngredientSummaryByDietId(id);
    }

    private void actualizarCalorias() {
        dietRepository.actualizarCalories();
    }

    @Override
    public Diet findById(Long id){
        return dietRepository.findById(id).orElse(null);
    }

    @Override
    public Diet save(Diet var1) {
        return dietRepository.save(var1);
    }

    @Override
    public List<Diet> findAll(){return dietRepository.findAll();}

    @Override
    public void deleteById(Long id){ dietRepository.deleteById(id);}

    @Override
    public Diet update(Diet diet) {
        try {
            dietRepository.findById(diet.getIdDiet());
        } catch (EntityNotFoundException e){
            throw new ServiceException("No existe el cliente en cuestion");
        }

        return dietRepository.save(diet);
    }

    @Override
    public List<RecipeInDiet> findRecipesByDiet(Long id) {

        List<RecipeDiet> recipeDietList = recipeDietService.findAll();

        List<RecipeInDiet> recipeList = new ArrayList<>();

        for (RecipeDiet recipeDiet: recipeDietList
             ) {
            if (recipeDiet.getDiet().getIdDiet().equals(id)){
                Recipe recipe = recipeService.findById(recipeDiet.getRecipe().getIdRecipe());
                recipeList.add(new RecipeInDiet(
                        recipe,
                        recipeDiet.getDayWeek(),
                        recipeDiet.getMealTime()));
            }
        }

        return recipeList;
    }
}
