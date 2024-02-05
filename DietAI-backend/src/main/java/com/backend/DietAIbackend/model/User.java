package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser", columnDefinition = "tinyint")
    private Long idUser;

    @Column(name = "name", columnDefinition = "varchar(100)",nullable = false, unique = true)
    private String name;

//    @Column(name = "lastName", columnDefinition = "varchar(100)")
//    private String lastName;

    @Column(name = "userName", columnDefinition = "varchar(100)",nullable = false, unique = true)
    private String userName;

//    @Column(name = "birthDate", columnDefinition = "date")
//    private LocalDate fechaNacimiento;

    @Column(name = "email", columnDefinition = "varchar(100)",nullable = false)
    private String email;

    @Column(name = "pass", columnDefinition = "varchar(100)",nullable = false)
    private String pass;

//    @Column(name = "weight", columnDefinition = "decimal")
//    private Float weight;
//
//    @Column(name = "height", columnDefinition = "decimal")
//    private Float height;
//
//    @ManyToOne
//    @JoinColumn(name = "idEntrenamiento", columnDefinition = "tinyint")
//    private Entrenamiento entrenamiento;
//
//    @ManyToOne
//    @JoinColumn(name = "idDieta", columnDefinition = "tinyint")
//    private Dieta dieta;
}
