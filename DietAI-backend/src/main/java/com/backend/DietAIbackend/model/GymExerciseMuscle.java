package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "gymExerciseMuscle")
public class GymExerciseMuscle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idGymExercise")
    private GymExercise gymExercise;

    @ManyToOne
    @JoinColumn(name = "idMuscle")
    private Muscle muscle;
}
