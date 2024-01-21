package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ejercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEjercicio", columnDefinition = "tinyint")
    private Long idEjercicio;

    @Column(name = "nombre", columnDefinition = "Varchar(100)")
    private String nombre;

    @ElementCollection
    private List<String> musculos;

    @Column(name = "dificultad", columnDefinition = "int")
    private Integer dificultad;

    @Column(name = "explicacion", columnDefinition = "Varchar(255)")
    private String explicacion;

    @OneToMany(mappedBy = "ejercicio")
    private List<EjerciciosEntrenamiento> ejerciciosEntrenamientos;
}
