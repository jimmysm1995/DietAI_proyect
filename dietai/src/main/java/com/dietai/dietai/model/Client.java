package com.dietai.dietai.model;

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

    @Column(name = "name", columnDefinition = "varchar(100)",nullable = false, unique = true)
    private String name;

    @Column(name = "lastName", columnDefinition = "varchar(100)")
    private String lastName;

    @Column(name = "birthDate", columnDefinition = "date")
    private LocalDate fechaNacimiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "plan", columnDefinition = "varchar(10)")
    private Plan plan;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", columnDefinition = "varchar(10)")
    private Gender gender;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    private User user;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private InfoClient infoClient;

    @ManyToOne
    @JoinColumn(name = "idTraining", columnDefinition = "tinyint")
    private Training training;

    @ManyToOne
    @JoinColumn(name = "idDiet", columnDefinition = "tinyint")
    private Diet diet;
}
