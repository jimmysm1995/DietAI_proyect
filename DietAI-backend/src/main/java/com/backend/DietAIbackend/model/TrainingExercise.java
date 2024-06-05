package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trainingExercise")
public class TrainingExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTrainingExercise", columnDefinition = "tinyint")
    private Long idTrainingExercise;

    @Column(name = "sets",columnDefinition = "INT")
    private int sets;

    @Column(name = "reps",columnDefinition = "INT")
    private int reps;

    @Column(name = "orderDay", columnDefinition = "INT")
    private Integer orderDay;

    @Column(name = "orderWeek", columnDefinition = "INT")
    private Integer orderWeek;

    @ManyToOne
    @JoinColumn(name = "idTraining")
    private Training training;

    @ManyToOne
    @JoinColumn(name = "idExercise")
    private Exercise exercise;


}
