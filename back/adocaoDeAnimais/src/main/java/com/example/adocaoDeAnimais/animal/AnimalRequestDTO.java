package com.example.adocaoDeAnimais.animal;

import java.time.LocalDate;

public record AnimalRequestDTO(String nome,
                               String raca,
                               LocalDate dataNasc,
                               boolean castracao,
                               String resumo,
                               boolean visivel,
                               String imagemUrl,
                               String vacinas
) {}
