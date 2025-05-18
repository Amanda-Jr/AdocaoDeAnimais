package com.example.adocaoDeAnimais.animal;

import jakarta.persistence.*;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
public class AnimalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String nome;
    private String raca;
    private LocalDate dataNasc;
    private boolean castracao;
    private String resumo;
    private boolean visivel;
   // private BufferedImage imagem;

    @OneToMany
    @JoinColumn(name = "vacinas_id")
    private List<VacinasModel> vacinas;
}
