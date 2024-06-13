package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.dto.IngredientSummary;
import com.backend.DietAIbackend.dto.RecipeInDiet;
import com.backend.DietAIbackend.exception.ServiceException;
import com.backend.DietAIbackend.model.*;
import com.backend.DietAIbackend.repository.DietRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DietServiceImp implements DietService {

    @Autowired
    private DietRepository dietRepository;

    @Autowired
    private RecipeDietService recipeDietService;

    @Autowired
    private DietAllergyService dietAllergyService;

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private ClientService clientService;

    /**
     *
     * Guarda la dieta
     *
     * @param diet
     * @param recipeInDietList
     * @param allergyList
     * @return
     */
    @Transactional
    @Override
    public Diet save(Diet diet, List<RecipeInDiet> recipeInDietList, List<Allergy> allergyList) {
        try {
            Diet savedDiet = dietRepository.save(diet);

            for (RecipeInDiet recipeInDiet : recipeInDietList) {
                if (recipeInDiet.recipe() != null) {
                    RecipeDiet recipeDiet = RecipeDiet.builder()
                            .diet(savedDiet)
                            .recipe(recipeInDiet.recipe())
                            .dayWeek(recipeInDiet.dayWeek())
                            .mealTime(recipeInDiet.mealTime())
                            .build();
                    recipeDietService.save(recipeDiet);
                }
            }

            for (Allergy allergy : allergyList) {
                dietAllergyService.save(savedDiet, allergy);
            }

            actualizarCalorias();

            return savedDiet;
        } catch (Exception e) {
            log.error("Error al guardar la dieta: ", e);
            throw new ServiceException("Ocurrió un error al guardar la dieta", HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Obtiene la lista de la compra de la dieta
     *
     * @param id
     * @return
     */
    @Override
    public List<IngredientSummary> getListaCompra(Long id) {
        try {
            return dietRepository.getIngredientSummaryByDietId(id);
        } catch (Exception e) {
            log.error("Error al obtener la lista de compra: ", e);
            throw new ServiceException("Ocurrió un error al obtener la lista de compra", HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Actualiza las calorias de las dietas
     */
    private void actualizarCalorias() {
        try {
            dietRepository.actualizarCalories();
        } catch (Exception e) {
            log.error("Error al actualizar calorías: ", e);
            throw new ServiceException("Ocurrió un error al actualizar las calorías", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Buscar la dieta por el id
     *
     * @param id
     * @return
     */
    @Override
    public Diet findById(Long id) {
        return dietRepository.findById(id)
                .orElseThrow(() -> new ServiceException("No se ha encontrado la dieta", HttpStatus.NOT_FOUND));
    }


    /**
     * Devuelve una lista con todas las dietas
     *
     * @return List<Diet>
     */
    @Override
    public List<Diet> findAll() {
        try {
            List<Diet> diets = dietRepository.findAll();
            if (diets.isEmpty()) {
                throw new ServiceException("No se encuentran dietas", HttpStatus.NOT_FOUND);
            }
            return diets;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Borra la dieta por el id
     *
     * @param id
     */
    @Override
    public void deleteById(Long id) {
        try {
            if (!dietRepository.existsById(id)) {
                throw new ServiceException("No se encontró la dieta para eliminar", HttpStatus.NOT_FOUND);
            }

            // Disociar los clients
            for (Client client : findById(id).getClients()) {
                client.setDiet(null);
                clientService.update(client);
            }

            dietRepository.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Actualiza la dieta
     *
     * @param diet
     * @return
     */
    @Override
    public Diet update(Diet diet) {
        try {
            if (!dietRepository.existsById(diet.getIdDiet())) {
                throw new ServiceException("No se encontró la dieta para actualizar", HttpStatus.NOT_FOUND);
            }
            return dietRepository.save(diet);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Devuelve una lista con las recetas en la dieta junto a sus horarios
     *
     * @param id
     * @return
     */
    @Override
    public List<RecipeInDiet> findRecipesByDiet(Long id) {
        try {
            List<RecipeDiet> recipeDietList = recipeDietService.findAll();
            List<RecipeInDiet> recipeList = new ArrayList<>();

            for (RecipeDiet recipeDiet : recipeDietList) {
                if (recipeDiet.getDiet().getIdDiet().equals(id)) {
                    Recipe recipe = recipeService.findById(recipeDiet.getRecipe().getIdRecipe());
                    recipeList.add(new RecipeInDiet(
                            recipe,
                            recipeDiet.getDayWeek(),
                            recipeDiet.getMealTime()));
                }
            }

            if (recipeList.isEmpty()){
                throw new ServiceException("No se encuentran recetas para la dieta", HttpStatus.NOT_FOUND);
            }

            return recipeList;
        } catch (Exception e) {
            throw e;
        }
    }
}


