package com.example.adocaoDeAnimais.animal;

public record AnimalResponseDTO(
        Long id,
        String animal,
        String size,
        String age,
        String location,
        String name,
        String image
) {}

