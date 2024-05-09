package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "allergy")
public class Allergy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAllergy;

    @Column(name = "name", columnDefinition = "Varchar(100)" ,nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "allergy")
    private List<ClientAllergy> clientAllergy;

    @OneToMany(mappedBy = "allergy")
    private List<RecipeAllergy> recipeAllergy;

    @OneToMany(mappedBy = "allergy")
    private List<DietAllergy> dietAllergy;
}
