package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
