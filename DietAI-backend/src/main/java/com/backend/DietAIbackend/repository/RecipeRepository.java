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
            "INNER JOIN ingredient_recipe inre ON ing.id_ingredient = inre.id_ingredient " +
            "WHERE re.id_recipe = inre.id_recipe " +
            "GROUP BY inre.id_recipe) " +
            "WHERE re.id_recipe IN (" +
            "SELECT id_recipe " +
            "FROM ingredient_recipe)", nativeQuery = true)
    void actualizarCalories();
}
