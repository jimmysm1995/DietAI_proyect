package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "Varchar(100)" ,nullable = false, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "typeTraining", columnDefinition = "Varchar(20)")
    private TypeTraining typeTraining;

    @Column(name = "difficulty", columnDefinition = "int")
    private Integer difficulty;

    @Column(name = "days", columnDefinition = "int")
    private Integer days;

    @Column(name = "distribution", columnDefinition = "Varchar(50)")
    private String distribution;

    @OneToMany(mappedBy = "training")
    private List<Client> clients;

    @OneToMany(mappedBy = "training")
    private List<TrainingExercise> trainingExercises;

}
