package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIngredient;

    @Column(name = "name", columnDefinition = "varchar(100)", unique = true)
    private String name;

    @Column(name = "protein", columnDefinition = "DOUBLE")
    private double protein; // Proteins in grams

    @Column(name = "carbohydrates" ,columnDefinition = "DOUBLE")
    private double carbohydrates; // Carbohydrates in grams

    @Column(name = "fats" ,columnDefinition = "DOUBLE")
    private double fats; // Fats in grams

    @Column(name = "calories", columnDefinition = "int")
    private Integer calories;

    @OneToMany(mappedBy = "ingredient")
    private List<IngredientRecipe> ingredientRecipe;
}
