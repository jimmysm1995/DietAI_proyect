package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "homeExerciseMuscle")
public class HomeExerciseMuscle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idHomeExercise")
    private HomeExercise homeExercise;

    @ManyToOne
    @JoinColumn(name = "idMuscle")
    private Muscle muscle;
}
