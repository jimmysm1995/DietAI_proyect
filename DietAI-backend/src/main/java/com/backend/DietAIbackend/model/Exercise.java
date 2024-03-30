package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idExercise", columnDefinition = "tinyint")
    private Long idExercise;

    @Column(name = "name", columnDefinition = "Varchar(100)" ,nullable = false, unique = true)
    private String name;

    @Column(name = "imgExercise", columnDefinition = "varchar(255)")
    private String imgExercise;

    @Column(name = "initialPosition", columnDefinition = "Varchar(255)")
    private String initialPosition;

    @Column(name = "execution", columnDefinition = "Varchar(255)")
    private String execution;

    @Column(name = "advices", columnDefinition = "Varchar(255)")
    private String advices;

    @Enumerated(EnumType.STRING)
    @Column(name = "typeTraining", columnDefinition = "Varchar(20)")
    private TypeTraining typeTraining;

    @OneToMany(mappedBy = "exercise")
    private List<ExerciseMuscle> exerciseMuscles;

    @OneToMany(mappedBy = "exercise")
    private List<TrainingExercise> trainingExercises;

}
