package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.DayOfWeek;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "dayWeek", columnDefinition = "varchar(10)")
    private DayOfWeek dayWeek;

    @ManyToOne
    @JoinColumn(name = "idTraining")
    private Training training;

    @ManyToOne
    @JoinColumn(name = "idExercise")
    private Exercise exercise;


}
