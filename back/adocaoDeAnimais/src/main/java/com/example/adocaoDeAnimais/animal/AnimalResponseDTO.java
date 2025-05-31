package com.example.adocaoDeAnimais.animal;

import java.time.LocalDate;

public record AnimalResponseDTO(
        Long id,
        String animal,
        String size,
        String age,
        String location,
        String name,
        String image,
        LocalDate dataNascimento,
        boolean vacinado,
        boolean castrado,
        String resumo
) {}

