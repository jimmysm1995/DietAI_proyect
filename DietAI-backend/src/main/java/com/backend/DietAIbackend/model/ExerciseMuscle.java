package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "exerciseMuscle")
public class ExerciseMuscle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExerciseMuscle;

    @ManyToOne
    @JoinColumn(name = "idExercise")
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name = "idMuscle")
    private Muscle muscle;
}
