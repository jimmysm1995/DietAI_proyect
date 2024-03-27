package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.model.Recipe;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface RecipeRepository extends JpaRepository <Recipe,Long> {

    @Modifying // Indica que la consulta modificará el estado de la base de datos
    @Transactional // Indica que la operación debe ser ejecutada en una transacción
    @Query(value = "UPDATE recipe re " +
            "SET re.calories = " +
            "(SELECT SUM(ing.calories * inre.quantity) AS totalCalories " +
            "FROM ingredient ing " +
            "INNER JOIN ingredient_recipe inre ON ing.id_ingredient = inre.ingredient_id " +
            "WHERE re.id_recipe = inre.recipe_id " +
            "GROUP BY inre.recipe_id) " +
            "WHERE re.id_recipe IN (" +
            "SELECT recipe_id " +
            "FROM ingredient_recipe)", nativeQuery = true)
    void actualizarCalories();
}
