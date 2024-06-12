package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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
    @Column(name = "gender", columnDefinition = "varchar(10)", nullable = false)
    private Gender gender;

    @Column(name = "weight", columnDefinition = "decimal(10,2)", nullable = false)
    @Size(min = 0, message = "El peso no puede ser negativo")
    private Float weight;

    @Column(name = "height", columnDefinition = "decimal(10,2)", nullable = false)
    @Size(min = 0, message = "La altura no puede ser negativo")
    private Float height;

    @Column(name = "recommendedDailyCalories", columnDefinition = "int")
    @Size(min = 0, message = "Las calorias recomendadas no pueden ser 0")
    private Integer recommendedDailyCalories;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "typeTraining", columnDefinition = "Varchar(20)", nullable = false)
    private TypeTraining typeTraining;

    @Column(name = "trainingTime", columnDefinition = "tinyint", nullable = false)
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
