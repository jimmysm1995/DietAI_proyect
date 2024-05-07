package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "dietAllergy")
public class DietAllergy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDietAllergy;

    @ManyToOne
    @JoinColumn(name = "idDiet")
    private Diet diet;

    @ManyToOne
    @JoinColumn(name = "idAllergy")
    private Allergy allergy;

}
