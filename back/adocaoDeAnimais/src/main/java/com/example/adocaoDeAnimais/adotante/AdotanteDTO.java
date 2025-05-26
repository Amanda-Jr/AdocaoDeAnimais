package com.example.adocaoDeAnimais.adotante;

import java.time.LocalDate;

public record AdotanteDTO(
        Long idAdotante,
        String nome,
        String email,
        String telefone
) {}
