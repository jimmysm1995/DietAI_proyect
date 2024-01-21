package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "recetaDieta")
public class RecetaDieta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRecetaDieta", columnDefinition = "tinyint")
    private Long idRecetaDieta;

    @ManyToOne
    @JoinColumn(name = "idDieta")
    private Dieta dietas;

    @ManyToOne
    @JoinColumn(name = "idReceta")
    private Receta receta;

    @Enumerated(EnumType.STRING)
    @Column(name = "diaSemana", columnDefinition = "varchar(50)")
    private DiaSemana diaSemana;

    @Enumerated(EnumType.STRING)
    @Column(name = "horaComida", columnDefinition = "varchar(50)")
    private HoraComida horaComida;


}
