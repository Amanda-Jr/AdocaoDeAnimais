package com.example.adocaoDeAnimais.animal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "tb_vacinas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacinasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vacina")
    private UUID id;

    @Column(name = "nome_vacina", nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private AnimalModel animal;
}
