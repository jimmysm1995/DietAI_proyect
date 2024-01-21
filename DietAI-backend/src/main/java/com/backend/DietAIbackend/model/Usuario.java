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
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario", columnDefinition = "tinyint")
    private Long idUsuario;

    @Column(name = "nombre", columnDefinition = "varchar(100)")
    private String nombre;

    @Column(name = "apellido", columnDefinition = "varchar(100)")
    private String apellido;

    @Column(name = "fechaNacimiento", columnDefinition = "date")
    private LocalDate fechaNacimiento;

    @Column(name = "email", columnDefinition = "varchar(100)")
    private String email;

    @Column(name = "pass", columnDefinition = "varchar(100)")
    private String pass;

    @Column(name = "peso", columnDefinition = "decimal")
    private Float peso;

    @Column(name = "altura", columnDefinition = "decimal")
    private Float altura;

    @Column(name = "objetivo", columnDefinition = "varchar(255)")
    private String objetivo;

    @ManyToOne
    @JoinColumn(name = "idEntrenamiento", columnDefinition = "tinyint")
    private Entrenamiento entrenamiento;

    @ManyToOne
    @JoinColumn(name = "idDieta", columnDefinition = "tinyint")
    private Dieta dieta;
}
