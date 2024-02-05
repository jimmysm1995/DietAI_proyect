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
@Table(name = "Entrenamiento")
public class Entrenamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEjercicio", columnDefinition = "tinyint")
    private Long idEntrenamiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoEntrenamiento", columnDefinition = "Varchar(20)")
    private TipoEntrenamiento tipoEntrenamiento;

    @Column(name = "dificultad", columnDefinition = "int")
    private Integer dificultad;

    @Column(name = "dias", columnDefinition = "int")
    private Integer dias;

    @Column(name = "distribucion", columnDefinition = "Varchar(50)")
    private String distribucion;

//    @OneToMany(mappedBy = "entrenamiento")
//    private List<User> usuarios;

    @OneToMany(mappedBy = "entrenamiento")
    private List<EjerciciosEntrenamiento> ejerciciosEntrenamientos;


}
