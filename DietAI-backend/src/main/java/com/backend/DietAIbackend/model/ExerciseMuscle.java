package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "exerciseMuscle")
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
