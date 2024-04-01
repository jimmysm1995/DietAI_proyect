package com.backend.DietAIbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecipe;

    @Column(name = "name", columnDefinition = "varchar(100)", unique = true)
    private String name;

    @Column(name = "calories", columnDefinition = "int")
    private Integer calories;

    @OneToMany(mappedBy = "recipe")
    @JsonIgnore
    private List<RecipeDiet> recipeDiets;

    @OneToMany(mappedBy = "recipe")
    @JsonIgnore
    private List<IngredientRecipe> ingredientRecipe;
}
