package com.dietai.dietai.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "InfoClient")
public class InfoClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idInfoClient", columnDefinition = "tinyint")
    private Long idInfoClient;

    @Column(name = "weight", columnDefinition = "decimal")
    private Float weight;

    @Column(name = "height", columnDefinition = "decimal")
    private Float height;

    @Enumerated(EnumType.STRING)
    @Column(name = "goal", columnDefinition = "varchar(255)")
    private Goal goal;

    @OneToOne
    @JoinColumn(name = "idUser")
    private Client client;
}
