package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "varchar(100)", unique = true)
    private String name;

    @Column(name = "calories", columnDefinition = "int")
    private Integer calories;

    @OneToMany(mappedBy = "recipe")
    private List<RecipeDiet> recipeDiets;

    @OneToMany(mappedBy = "recipe")
    private List<IngredientRecipe> ingredientRecipe;
}
