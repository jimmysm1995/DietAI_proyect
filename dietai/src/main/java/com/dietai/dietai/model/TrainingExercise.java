package com.dietai.dietai.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "trainingExercise")
public class TrainingExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTrainingExercise", columnDefinition = "tinyint")
    private Long idTrainingExercise;

    @Column(name = "sets",columnDefinition = "INT")
    private int sets;

    @Column(name = "repetitions",columnDefinition = "INT")
    private int repetitions;

    @ManyToOne
    @JoinColumn(name = "idTraining")
    private Training training;

    @ManyToOne
    @JoinColumn(name = "idGymExercise")
    private GymExercise gymExercise;

    @ManyToOne
    @JoinColumn(name = "idHomeExercise")
    private HomeExercise homeExercise;

}
