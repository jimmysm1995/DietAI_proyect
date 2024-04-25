package com.backend.DietAIbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "imgExercise", length = 1000)
    private String imgExercise;

    @Column(name = "initialPosition", length = 1000)
    private String initialPosition;

    @Column(name = "execution", length = 1000)
    private String execution;

    @Column(name = "advices", length = 1000)
    private String advices;

    @Enumerated(EnumType.STRING)
    @Column(name = "typeTraining", columnDefinition = "Varchar(20)")
    private TypeTraining typeTraining;

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ExerciseMuscle> exerciseMuscles;

    @OneToMany(mappedBy = "exercise")
    @JsonIgnore
    private List<TrainingExercise> trainingExercises;
}
