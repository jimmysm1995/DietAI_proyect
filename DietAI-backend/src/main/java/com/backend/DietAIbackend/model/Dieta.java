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
@Table(name = "dieta")
public class Dieta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDieta;

    @Column(name = "calorias", columnDefinition = "int")
    private Integer calorias;

    @OneToMany(mappedBy = "dietas")
    private List<RecetaDieta> recetaDietas;

//    @OneToMany(mappedBy = "dieta")
//    private List<User> usuarios;
}
