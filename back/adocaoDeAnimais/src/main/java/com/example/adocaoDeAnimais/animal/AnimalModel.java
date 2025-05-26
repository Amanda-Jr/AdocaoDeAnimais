package com.example.adocaoDeAnimais.animal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_animais")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_animal")
    private Long idAnimal;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "raca")
    private String raca;

    @Column(name = "data_nascimento")
    private LocalDate dataNasc;

    @Column(name = "eh_castrado")
    private boolean castracao;

    @Column(name = "resumo_animal", length = 500)
    private String resumo;

    @Column(name = "esta_visivel")
    private boolean visivel;

    @Column(name = "imagens")
    private String imagemUrl;

    @ElementCollection
    private List<String> vacinas;

}
