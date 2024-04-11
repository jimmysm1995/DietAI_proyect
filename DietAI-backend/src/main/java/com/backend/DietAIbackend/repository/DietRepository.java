package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.dto.IngredientSummary;
import com.backend.DietAIbackend.model.Diet;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DietRepository extends JpaRepository<Diet,Long> {

    @Modifying // Indica que la consulta modificará el estado de la base de datos
    @Transactional // Indica que la operación debe ser ejecutada en una transacción
    @Query(value = "UPDATE diet di " +
                    "SET di.calories = ( " +
                    "SELECT SUM(re.calories)/7 AS totalCalories " +
                    "FROM recipe re " +
                    "INNER JOIN recipe_diet redi ON re.id_recipe = redi.id_recipe " +
                    "WHERE di.id_diet = redi.id_diet " +
                    "GROUP BY redi.id_diet " +
                    ") " +
                    "WHERE di.id_diet IN ( " +
                    "SELECT id_diet " +
                    "FROM recipe_diet " +
                    " );", nativeQuery = true)
    void actualizarCalories();


    @Modifying
    @Transactional
    @Query("SELECT new com.backend.DietAIbackend.dto.IngredientSummary(ig.id, ig.name, SUM(ir.quantity * 100) AS totalQuantity) " +
                "FROM Diet di " +
                "INNER JOIN RecipeDiet rd ON di.id = rd.diet.id " +
                "INNER JOIN Recipe re ON rd.recipe.id = re.id " +
                "INNER JOIN IngredientRecipe ir ON re.id = ir.recipe.id " +
                "INNER JOIN Ingredient ig ON ir.ingredient.id = ig.id " +
                "WHERE di.id = :dietId " +
                "GROUP BY ig.id, ig.name")
    List <IngredientSummary> getIngredientSummaryByDietId(@Param("dietId") Long dietId);
}

