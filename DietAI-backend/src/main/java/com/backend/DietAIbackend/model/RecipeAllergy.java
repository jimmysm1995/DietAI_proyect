package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "recipeAllergy")
public class RecipeAllergy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecipeAllergy;

    @ManyToOne
    @JoinColumn(name = "idRecipe")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "idAllergy")
    private Allergy allergy;
}
