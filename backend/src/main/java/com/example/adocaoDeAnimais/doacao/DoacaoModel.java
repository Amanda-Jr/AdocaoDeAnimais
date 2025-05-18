package com.example.adocaoDeAnimais.doacao;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_doacoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoacaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;

    @Column(name = "nome_doador", nullable = false)
    private String nomeDoador;

    @Column(name = "valor_doado")
    private double valor;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNasc;

    @Column(name = "data_doacao", nullable = false, updatable = false)
    private LocalDateTime dataDoacao;
}
