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
@Table(name = "diet")
public class Diet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDiet", columnDefinition = "tinyint")
    private Long idDiet;

    @Column(name = "name", columnDefinition = "varchar(100)",nullable = false, unique = true)
    private String name;

    @Column(name = "calories", columnDefinition = "int")
    private Integer calories;

    @OneToMany(mappedBy = "diet" , cascade = CascadeType.ALL)
    private List<RecipeDiet> recipeDiets;

    @OneToMany(mappedBy = "diet", cascade = CascadeType.ALL)
    private List<DietAllergy> dietAllergy;

    @OneToMany(fetch =  FetchType.LAZY ,mappedBy = "diet")
    private List<Client> clients;
}
