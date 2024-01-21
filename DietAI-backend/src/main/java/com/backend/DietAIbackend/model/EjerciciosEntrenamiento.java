package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EjerciciosEntrenamiento")
public class EjerciciosEntrenamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEjerEntre", columnDefinition = "tinyint")
    private Long idEjerEntre;

    @ManyToOne
    @JoinColumn(name = "idEntrenamiento")
    private Entrenamiento entrenamiento;

    @ManyToOne
    @JoinColumn(name = "idEjercicio")
    private Ejercicio ejercicio;

    @Column(name = "orden", columnDefinition = "int")
    private Integer orden;

    @Column(name = "rondas", columnDefinition = "int")
    private Integer rondas;

    @Column(name = "repeticiones", columnDefinition = "varchar(100)")
    private String repeticiones;

    @Enumerated(EnumType.STRING)
    @Column(name = "diaSemana", columnDefinition = "varchar(50)")
    private DiaSemana diaSemana;
}
