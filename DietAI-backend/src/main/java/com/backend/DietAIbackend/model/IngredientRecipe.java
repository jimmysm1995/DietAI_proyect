package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "ingredientRecipe")
public class IngredientRecipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIngredientRecipe;

    @Column(name = "quantity", columnDefinition = "decimal(10,2)")
    private double quantity;

    @ManyToOne
    @JoinColumn(name = "idIngredient")
    private Ingredient ingredient;

    @ManyToOne
    @JoinColumn(name = "idRecipe")
    private Recipe recipe;
}
