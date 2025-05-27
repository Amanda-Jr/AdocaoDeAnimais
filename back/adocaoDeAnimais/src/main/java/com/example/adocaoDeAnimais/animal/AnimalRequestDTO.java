package com.example.adocaoDeAnimais.animal;

public record AnimalRequestDTO(
        String animal,
        String size,
        String age,
        String location,
        String name,
        String image
) {}
