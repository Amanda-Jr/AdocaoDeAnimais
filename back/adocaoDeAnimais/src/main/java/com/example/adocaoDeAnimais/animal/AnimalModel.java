package com.example.adocaoDeAnimais.animal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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

    @Column(name = "tipo_animal", nullable = false)
    private String animal;

    @Column(name = "tamanho")
    private String size;

    @Column(name = "idade")
    private String age;

    @Column(name = "localizacao")
    private String location;

    @Column(name = "nome")
    private String nome;

    @Column(name = "imagem")
    private String imagemUrl;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "vacinado")
    private Boolean vacinado;

    @Column(name = "castrado")
    private Boolean castrado;

    @Column(name = "resumo", length = 500)
    private String resumo;

    @Column(name = "visibilidade")
    private Boolean visivel;

}
