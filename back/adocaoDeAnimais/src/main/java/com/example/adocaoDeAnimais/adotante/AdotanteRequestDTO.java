package com.example.adocaoDeAnimais.adotante;

public record AdotanteRequestDTO(
        String nome,
        String email,
        String telefone,
        String senha
) {}

