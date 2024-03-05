package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClient", columnDefinition = "tinyint")
    private Long idClient;

    @Column(name = "name", columnDefinition = "varchar(100)")
    private String name;

    @Column(name = "lastName", columnDefinition = "varchar(100)")
    private String lastName;

    @Column(name = "birthDate", columnDefinition = "date")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "plan", columnDefinition = "varchar(10)")
    private Plan plan;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", columnDefinition = "varchar(10)")
    private Gender gender;

    @Column(name = "weight", columnDefinition = "decimal")
    private Float weight;

    @Column(name = "height", columnDefinition = "decimal")
    private Float height;

    @Enumerated(EnumType.STRING)
    @Column(name = "goal", columnDefinition = "varchar(255)")
    private Goal goal;

    @Column(columnDefinition = "varchar(255)")
    private String injuries;

    @Enumerated(EnumType.STRING)
    @Column(name = "allergy", columnDefinition = "varchar(50)")
    private Allergy allergy;

    @Enumerated(EnumType.STRING)
    @Column(name = "jobType", columnDefinition = "varchar(255)")
    private JobType jobType;

    @Enumerated(EnumType.STRING)
    @Column(name = "previousLevel", columnDefinition = "varchar(255)")
    private PreviusLevel previousLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "consumedSubstances", columnDefinition = "varchar(255)")
    private ConsumedSubstances consumedSubstances;

    @Column(name = "trainingTime", columnDefinition = "tinyint")
    private Integer trainingTime;

    @Column(name = "dietAndExerciseFrequency", columnDefinition = "varchar(255)")
    private String dietAndExerciseFrequency;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idTraining", columnDefinition = "tinyint")
    private Training training;

    @ManyToOne
    @JoinColumn(name = "idDiet", columnDefinition = "tinyint")
    private Diet diet;
}
