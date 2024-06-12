package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "dietAllergy")
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
