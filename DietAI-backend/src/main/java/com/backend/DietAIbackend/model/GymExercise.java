package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "gymExercise")
public class GymExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "Varchar(100)" ,nullable = false, unique = true)
    private String name;

    @Column(name = "difficult", columnDefinition = "int")
    private Integer difficult;

    @Column(name = "explanation", columnDefinition = "Varchar(255)")
    private String explanation;

    @OneToMany(mappedBy = "gymExercise")
    private List<GymExerciseMuscle> gymExerciseMuscles;

    @OneToMany(mappedBy = "gymExercise")
    private List<TrainingExercise> trainingExercises;
}
