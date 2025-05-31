package com.example.adocaoDeAnimais.animal;

import java.time.LocalDate;

public record AnimalRequestDTO(
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
