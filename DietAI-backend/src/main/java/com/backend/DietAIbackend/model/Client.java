package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClient", columnDefinition = "tinyint")
    private Long idClient;

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

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<ClientAllergy> clientAllergy;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<ClientInjury> clientInjury;

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
