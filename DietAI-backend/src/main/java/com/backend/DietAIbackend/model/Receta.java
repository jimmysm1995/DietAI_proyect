package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Receta")
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReceta;

    @Column(name = "nombre", columnDefinition = "varchar(100)")
    private String nombre;

    @ElementCollection
    private List<String> ingredientes;

    @Column(name = "pasos", columnDefinition = "varchar(255)")
    private String pasos;

    @Column(name = "calorias", columnDefinition = "int")
    private Integer calorias;

    @OneToMany(mappedBy = "receta")
    private List<RecetaDieta> recetaDietas;
}
