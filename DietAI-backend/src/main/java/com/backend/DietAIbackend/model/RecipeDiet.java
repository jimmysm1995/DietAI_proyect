package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;

@Entity
@Data
@Table(name = "recipeDiet")
public class RecipeDiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idDiet")
    private Diet diet;

    @ManyToOne
    @JoinColumn(name = "idRecipe")
    private Recipe recipe;

    @Enumerated(EnumType.STRING)
    @Column(name = "dayWeek", columnDefinition = "varchar(10)")
    private DayOfWeek dayOfWeek;

    @Enumerated(EnumType.STRING)
    @Column(name = "mealTime", columnDefinition = "varchar(10)")
    private MealTime mealTime;
}
