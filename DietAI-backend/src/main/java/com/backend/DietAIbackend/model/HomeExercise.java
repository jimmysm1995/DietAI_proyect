package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "homeExercise")
public class HomeExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHomeExercise", columnDefinition = "tinyint")
    private Long idHomeExercise;

    @Column(name = "name", columnDefinition = "Varchar(100)" ,nullable = false, unique = true)
    private String name;

    @Column(name = "difficult", columnDefinition = "int")
    private Integer difficult;

    @Column(name = "explanation", columnDefinition = "Varchar(255)")
    private String explanation;

    @OneToMany(mappedBy = "homeExercise")
    private List<HomeExerciseMuscle> homeExerciseMuscles;

    @OneToMany(mappedBy = "homeExercise")
    private List<TrainingExercise> trainingExercises;

}
