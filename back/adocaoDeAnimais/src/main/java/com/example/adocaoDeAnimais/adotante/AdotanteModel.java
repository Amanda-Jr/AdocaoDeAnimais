package com.example.adocaoDeAnimais.adotante;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_adotantes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdotanteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdotante;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String senha;

}
