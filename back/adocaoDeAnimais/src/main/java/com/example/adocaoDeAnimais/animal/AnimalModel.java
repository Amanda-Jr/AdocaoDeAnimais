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

}
