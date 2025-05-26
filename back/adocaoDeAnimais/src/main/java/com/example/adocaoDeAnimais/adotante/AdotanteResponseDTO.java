package com.example.adocaoDeAnimais.adotante;

public record AdotanteResponseDTO(
        Long idAdotante,
        String nome,
        String email,
        String telefone
) {}
