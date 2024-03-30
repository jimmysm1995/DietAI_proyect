package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "muscle")
public class Muscle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMuscle;

    @Column(name = "name", columnDefinition = "Varchar(100)" ,nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "muscle")
    private List<ExerciseMuscle> exerciseMuscles;

}
