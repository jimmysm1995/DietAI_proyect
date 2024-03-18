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
    private Long id;

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
    @JoinColumn(name = "idGymExercise")
    private GymExercise gymExercise;

    @ManyToOne
    @JoinColumn(name = "idHomeExercise")
    private HomeExercise homeExercise;

}
